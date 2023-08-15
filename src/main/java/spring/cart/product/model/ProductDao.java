package spring.cart.product.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    Product getById(int id);

    List<Product> findAll();

    void deleteById(int id);
}
