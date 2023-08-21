package spring.mall.web.product.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    Product getById(int id);
    Product findById(int id);

    List<Product> findAll();

    Product save(Product product);

    long count();

}
