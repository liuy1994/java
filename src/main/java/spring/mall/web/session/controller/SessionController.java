package spring.mall.web.session.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.mall.web.session.controller.validator.RegisterRequestValidator;
import spring.mall.web.session.model.Session;
import spring.mall.web.session.model.SessionManager;
import spring.mall.web.session.view.LoginRequest;
import spring.mall.web.session.view.RegisterRequest;
import spring.mall.web.user.model.User;
import spring.mall.web.user.model.UserDao;
import spring.mall.web.user.model.UserSimple;

import java.util.UUID;

@RestController
public class SessionController {
    private static final String SESSION_TOKEN = "session_token";
    private static final String USER_ID = "user_id";

    private UserDao userDao;
    private SessionManager sessionManager;

    private RegisterRequestValidator registerRequestValidator;

    public SessionController(UserDao userDao, SessionManager sessionManager, RegisterRequestValidator registerRequestValidator) {
        this.userDao = userDao;
        this.sessionManager = sessionManager;
        this.registerRequestValidator = registerRequestValidator;
    }


    @PostMapping("/register")
    public ResponseEntity register(HttpServletResponse response, @RequestBody RegisterRequest registerRequest) {
        boolean valid = registerRequestValidator.validate(registerRequest);
        if (!valid) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User user = new User(registerRequest.getUsername(), registerRequest.getPassword());

        userDao.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<UserSimple> login(HttpServletResponse response, @RequestBody LoginRequest loginRequest) {
        User user = userDao.getByUsername(loginRequest.getUsername());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        String token = UUID.randomUUID().toString();
        sessionManager.getSessions().put(user.getId(), new Session(user.getId(), token));
        System.out.println("Token: " + token);
        return new ResponseEntity(new UserSimple(user.getId(), user.getUsername(), token), HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<UserSimple> current(@RequestHeader(name = USER_ID, defaultValue = "0") long userId, @RequestHeader(name = SESSION_TOKEN, defaultValue = "token") String token) {
        Session session = sessionManager.getSessions().get(userId);
        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        User user = userDao.getById(session.getUserId());
        return new ResponseEntity<>(new UserSimple(user.getId(), user.getUsername()), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader(name = USER_ID, defaultValue = "0") long userId, @RequestHeader(name = SESSION_TOKEN, defaultValue = "token") String token) {
        Session session = sessionManager.getSessions().get(userId);
        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        sessionManager.getSessions().remove(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
