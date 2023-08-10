package spring.user.model;

import org.springframework.stereotype.Component;
import spring.user.User;

import java.util.HashMap;
import java.util.List;

@Component
public class UserMockDao implements UserDao{
    private final HashMap<String, User> users = new HashMap<>();
    public UserMockDao() {

    }
    @Override
    public boolean containsKey(String key) {
        return users.containsKey(key);
    }

    @Override
    public User get(String key) {
        return users.get(key);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(String key) {
        users.remove(key);
    }

    public User getUser(String key) {
        return users.get(key);
    }
}
