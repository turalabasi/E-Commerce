package management.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import management.AdminManagement;
import management.CategoryManagement;
import service.CategoryService;
import service.impl.ICategoryService;
import util.MenuUtil;

public class ICategoryManagement implements CategoryManagement {
    @Override
    public void manage() {
        CategoryService categoryService = new ICategoryService();
        AdminManagement adminManagement = new IAdminManagement();
        while (true){
            try {
                byte option = MenuUtil.categoryMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        categoryService.createCategory();
                        break;
                    case 2:
                        categoryService.showAllCategory();
                        break;
                    case 3:
                        categoryService.findById();
                        break;
                    case 4:
                        categoryService.findByName();
                        break;
                    case 5:
                        categoryService.updateCategory();
                        break;
                    case 6:
                        categoryService.deleteCategory();
                        break;
                    case 7:
                        adminManagement.manage();
                        break;
                    default:throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
