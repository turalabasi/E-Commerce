package management.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import helper.ServiceHelper;
import management.LoginManagement;
import management.MainManagement;
import util.MenuUtil;

public class IMainManagement implements MainManagement {
    @Override
    public void manage() {
        LoginManagement loginManagement = new ILoginManagement();

        while (true) {
            try {
                byte option = MenuUtil.entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        ServiceHelper.adminLogin();
                        break;
                    case 2:
                        loginManagement.manage();
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
