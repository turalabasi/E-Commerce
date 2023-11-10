package management.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import management.AdminManagement;
import management.BrandManagement;
import service.BrandService;
import service.impl.IBrandService;
import util.MenuUtil;

public class IBrandManagement implements BrandManagement {
    @Override
    public void manage() {
        BrandService brandService = new IBrandService();
        AdminManagement adminManagement = new IAdminManagement();
        while (true) {
            try {
                byte option = MenuUtil.brandMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        brandService.createBrand();
                        break;
                    case 2:
                        brandService.findAll();
                        break;
                    case 3:
                        brandService.findById();
                        break;
                    case 4:
                        brandService.findByName();
                        break;
                    case 5:
                        brandService.update();
                        break;
                    case 6:
                        brandService.delete();
                        break;
                    case 7:
                        adminManagement.manage();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}
