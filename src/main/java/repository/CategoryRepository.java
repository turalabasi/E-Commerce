package repository;

import model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    int createCategory(Category category);
    List<Category> findAll();
    List<Category> findByName(String name);
    Optional<Category> findById(long id);
    void delete(Category category);
    int update(Category category);
}
