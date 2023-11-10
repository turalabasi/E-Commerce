package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import helper.ServiceHelper;
import model.entity.Category;
import repository.CategoryRepository;
import repository.impl.ICategoryRepository;
import service.CategoryService;
import util.InputUtil;

import static model.constant.Constant.*;

public class ICategoryService implements CategoryService {
    CategoryRepository categoryRepository = new ICategoryRepository();

    @Override
    public void createCategory() {
        Category category = ServiceHelper.fillCategory();
        categoryRepository.createCategory(category);
        System.out.println(SAVED_SUCCESSFULLY);
    }

    @Override
    public void showAllCategory() {
        categoryRepository.findAll().forEach(System.out::println);
    }

    @Override
    public Category findById() {
        long id = InputUtil.getInstance().inputLong("Enter the category id: ");
        return  categoryRepository.findById(id).orElseThrow(()->new ApplicationException(ExceptionEnums.CATEGORY_NOT_FOUND));
    }

    @Override
    public void findByName() {
        String name = InputUtil.getInstance().inputString("Enter the founded name: ");
        categoryRepository.findByName(name);
    }

    @Override
    public void updateCategory() {
        showAllCategory();
        long id = InputUtil.getInstance().inputLong("Enter the id to update :");
        Category category = categoryRepository.findById(id).orElseThrow(()->new ApplicationException(ExceptionEnums.CATEGORY_NOT_FOUND));
        String description = InputUtil.getInstance().inputString("Enter the new description: ");
        category.setDescription(description);

        categoryRepository.update(category);
        System.out.println(UPDATE_SUCCESSFULLY);

    }

    @Override
    public void deleteCategory() {
        showAllCategory();
        long id = InputUtil.getInstance().inputLong("Enter the id to delete :");
        Category category = categoryRepository.findById(id).orElseThrow(()->new ApplicationException(ExceptionEnums.CATEGORY_NOT_FOUND));

        category.setStatus(false);
        categoryRepository.update(category);
        System.out.println(DELETE_SUCCESSFULLY);

    }
}
