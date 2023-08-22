package spring.mall.web.user.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User getByUsername(String username);

    User getById(long id);

    List<User> findAll();

    User save(User user);

    long count();

}
