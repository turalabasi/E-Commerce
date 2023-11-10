package management.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import management.AdminManagement;
import management.OrderManagement;
import service.OrderService;
import service.impl.IOrderService;
import util.MenuUtil;

public class IOrderManagement implements OrderManagement {
    @Override
    public void manage() {
        AdminManagement adminManagement = new IAdminManagement();
        OrderService orderService = new IOrderService();
        while (true) {
            try {
                byte option = MenuUtil.orderMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        orderService.findAll();
                        break;
                    case 2:
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
