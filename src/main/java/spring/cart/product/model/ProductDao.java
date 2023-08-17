package spring.cart.product.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    Product getById(int id);
}
