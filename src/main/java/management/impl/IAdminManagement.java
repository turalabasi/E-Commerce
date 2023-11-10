package management.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import management.*;
import util.MenuUtil;

public class IAdminManagement implements AdminManagement {
    @Override
    public void manage() {
        BrandManagement brandManagement = new IBrandManagement();
        CategoryManagement categoryManagement = new ICategoryManagement();
        ProductManagement productManagement = new IProductManagement();
        OrderManagement orderManagement = new IOrderManagement();
        MainManagement management = new IMainManagement();
        while (true){
            try {
                byte option = MenuUtil.adminMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                    case 1:
                        categoryManagement.manage();
                        break;
                    case 2:
                        brandManagement.manage();
                        break;
                    case 3:
                        productManagement.manage();
                        break;
                    case 4:
                        orderManagement.manage();
                        break;
                    case 5:
                        management.manage();
                        break;
                    default:throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            }catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }
}
