package service;

import model.entity.Category;

public interface CategoryService {
    void createCategory();
    void showAllCategory();
    Category findById();
    void findByName();
    void updateCategory();
    void deleteCategory();

}
