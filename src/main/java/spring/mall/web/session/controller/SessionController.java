package spring.mall.web.session.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.mall.util.JwtUtil;
import spring.mall.web.common.Result;
import spring.mall.web.session.controller.validator.RegisterRequestValidator;
import spring.mall.web.session.model.Session;
import spring.mall.web.session.model.SessionManager;
import spring.mall.web.session.view.LoginRequest;
import spring.mall.web.session.view.RegisterRequest;
import spring.mall.web.user.model.User;
import spring.mall.web.user.model.UserDao;
import spring.mall.web.user.model.UserSimple;

import java.util.UUID;

import static spring.mall.config.Constant.SESSION_TOKEN;

@RestController
public class SessionController {
    private UserDao userDao;
    private SessionManager sessionManager;

    private RegisterRequestValidator registerRequestValidator;

    public SessionController(UserDao userDao, SessionManager sessionManager, RegisterRequestValidator registerRequestValidator) {
        this.userDao = userDao;
        this.sessionManager = sessionManager;
        this.registerRequestValidator = registerRequestValidator;
    }


    @PostMapping("/register")
    public ResponseEntity<Result> register(HttpServletResponse response, @RequestBody RegisterRequest registerRequest) {
        boolean valid = registerRequestValidator.validate(registerRequest);
        if (!valid) {
            return new ResponseEntity<>(new Result<>("用户名已存在"), HttpStatus.OK);
        }
        User user = new User(registerRequest.getUsername(), registerRequest.getPassword());

        userDao.save(user);
        user.setPassword(null);
        return new ResponseEntity<>(new Result<>(user), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Result<UserSimple>> login(HttpServletResponse response, @RequestBody LoginRequest loginRequest) {
        User user = userDao.getByUsername(loginRequest.getUsername());
        if (user == null) {
            return new ResponseEntity<>(new Result<>("用户不存在"),HttpStatus.OK);
        }
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity<>(new Result<>("密码不正确"),HttpStatus.OK);
        }
        String token = JwtUtil.createToken(user);
        System.out.println("Token: " + token);
        UserSimple userSimple = new UserSimple(user.getId(), user.getUsername());
        userSimple.setToken(token);
        return new ResponseEntity<>(new Result<>(userSimple), HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<Result<UserSimple>> current(@RequestHeader(name = SESSION_TOKEN, defaultValue = "token") String token) {
        UserSimple userSimple = JwtUtil.parseToken(token);
        if (userSimple == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        User user = userDao.getById(userSimple.getId());
        return new ResponseEntity<>(new Result<>(new UserSimple(user.getId(), user.getUsername())), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout( @RequestHeader(name = SESSION_TOKEN, defaultValue = "token") String token) {
//        Session session = sessionManager.getSessions().get(userId);
//        if (session == null || !session.getToken().equals(token)) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//        sessionManager.getSessions().remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
