package repository;

import model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    int createProduct(Product product);
    List<Product> findAll();
    List<Product> findByName(String name);
    Optional<Product> findById(long id);
    void delete(Product product);
    int update(Product product);
}
