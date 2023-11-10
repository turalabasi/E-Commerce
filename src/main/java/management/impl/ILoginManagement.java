package management.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import helper.ServiceHelper;
import management.AdminManagement;
import management.LoginManagement;
import util.MenuUtil;

public class ILoginManagement implements LoginManagement {


    @Override
    public void manage() {
        AdminManagement adminManagement = new IAdminManagement();

        while (true) {
            try {
                byte option = MenuUtil.loginMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        ServiceHelper.login();
                        break;
                    case 2:
                        ServiceHelper.signIn();
                        break;
                    case 3:
                        adminManagement.manage();
                    default:
                        throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);

                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
}
