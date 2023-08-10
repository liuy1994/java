package spring.user.model;

import spring.user.User;

import java.util.List;

public interface UserDao {
    boolean containsKey(String key);
    User get(String key);

    List<User> getAll();

    void delete(String key);
}
