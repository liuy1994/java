package spring.mall.web.cart.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface CartItemDao extends CrudRepository<CartItem, Integer> {

    CartItem findById(int id);

    List<CartItem> findAll();

    List<CartItem> findByUserId(long user_id);

    CartItem save(CartItem cartItem);


}
