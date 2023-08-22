package spring.mall.web.session.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.mall.web.session.model.Session;
import spring.mall.web.session.model.SessionManager;
import spring.mall.web.session.view.LoginRequest;
import spring.mall.web.user.model.User;
import spring.mall.web.user.model.UserDao;

import java.util.UUID;

@RestController
public class SessionController {
    private static final String SESSION_TOKEN = "session_token";
    private static final String USER_ID = "user_id";

    private UserDao userDao;
    private SessionManager sessionManager;

    public SessionController(UserDao userDao, SessionManager sessionManager) {
        this.userDao = userDao;
        this.sessionManager = sessionManager;
    }


    @PostMapping("/register")
    public ResponseEntity register(HttpServletResponse response, @RequestBody LoginRequest loginRequest) {
//        User user = new User(loginRequest.getUsername(), loginRequest.getPassword());
//        userDao.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(HttpServletResponse response, @RequestBody LoginRequest loginRequest) {
        User user = userDao.getByName(loginRequest.getUsername());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
        String token = UUID.randomUUID().toString();
        sessionManager.getSessions().put(user.getId(), new Session(user.getId(), token));
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<User> current(@CookieValue(name = USER_ID, defaultValue = "0") long userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "token") String token) {
        Session session = sessionManager.getSessions().get(userId);
        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        User user = userDao.getById(session.getUserId());
        return new ResponseEntity<>(new User(user.getId(), user.getName()), HttpStatus.OK);
    }

    @DeleteMapping("/logout")
    public ResponseEntity logout(@CookieValue(name = USER_ID, defaultValue = "0") long userId, @CookieValue(name = SESSION_TOKEN, defaultValue = "token") String token) {
        Session session = sessionManager.getSessions().get(userId);
        if (session == null || !session.getToken().equals(token)) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        sessionManager.getSessions().remove(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
