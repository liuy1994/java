package spring.mall.web.session.controller.validator;

import org.springframework.stereotype.Component;
import spring.mall.web.session.view.RegisterRequest;
import spring.mall.web.user.model.User;
import spring.mall.web.user.model.UserDao;

@Component
public class RegisterRequestValidator {
    private UserDao userDao;
    public RegisterRequestValidator(UserDao userDao) {
        this.userDao = userDao;
    }
    public boolean validate(RegisterRequest request) {
        String username = request.getUsername();

        User user = userDao.getByName(username);
        if (user != null) {
            return false;
        }
        return true;
    }
}
