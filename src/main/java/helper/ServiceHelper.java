package helper;

import enums.ExceptionEnums;
import exception.ApplicationException;
import management.AdminManagement;
import management.UserManagement;
import management.impl.IAdminManagement;
import management.impl.IUserManagement;
import model.constant.Constant;
import model.entity.*;
import service.BrandService;
import service.CategoryService;
import service.UserService;
import service.impl.IBrandService;
import service.impl.ICategoryService;
import service.impl.IUserService;
import util.InputUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceHelper {

    static BrandService brandService = new IBrandService();
    static CategoryService categoryService = new ICategoryService();

    public static Product fillProduct() {
        brandService.findAll();

        Brand brand = brandService.findById();

        categoryService.showAllCategory();

        Category category = categoryService.findById();

        String name = InputUtil.getInstance().inputString("Enter the name: ");
        String description = InputUtil.getInstance().inputString("Enter the description: ");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(InputUtil.getInstance().inputString("Enter the price: ")));
        long remainCount = InputUtil.getInstance().inputInt("Enter the product stockCount: ");
        String color = InputUtil.getInstance().inputString("Enter the color: ");
        String size = InputUtil.getInstance().inputString("Enter the size: ");

        Product product = Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .brand(brand)
                .category(category)
                .comment(new ArrayList<>())
                .remainCount(remainCount)
                .productDetails(ProductDetails.builder()
                        .color(color)
                        .size(size)
                        .build())
                .build();

        return product;


    }

    public static Product updateProduct(Product product) {
        String description = InputUtil.getInstance().inputString("enter the new description: ");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(InputUtil.getInstance().inputString("Enter the new amount: ")));
        long remainCount = InputUtil.getInstance().inputInt("Enter the product new  stock count: ");
        product.setDescription(description);
        product.setPrice(price);
        product.setRemainCount(remainCount);
        return product;
    }

    public static Category fillCategory() {
        String name = InputUtil.getInstance().inputString("Enter the category name: ");
        String description = InputUtil.getInstance().inputString("Enter the description: ");

        Category category = Category.builder()
                .name(name)
                .description(description)
                .products(new ArrayList<>())
                .build();
        return category;
    }

    public static Brand fillBrand() {
        String name = InputUtil.getInstance().inputString("Enter the bran name: ");
        String description = InputUtil.getInstance().inputString("Enter the description: ");
        categoryService.showAllCategory();


        Brand brand = Brand.builder()
                .name(name)
                .description(description)
                .build();
        return brand;

    }


    public static User fillUser() {
        String name = InputUtil.getInstance().inputString("Enter the name: ");
        String surname = InputUtil.getInstance().inputString("Enter the surname: ");
        LocalDate birthdate = LocalDate.parse(InputUtil.getInstance().inputString("Enter the birthdate: "));
        String fin = InputUtil.getInstance().inputString("Enter the fin: ");
        String email = InputUtil.getInstance().inputString("Enter the email: ");
        String password = InputUtil.getInstance().inputString("Enter the password: ");
        String phoneNumber = InputUtil.getInstance().inputString("Enter the phone number: ");

        User user = User.builder()
                .name(name)
                .surname(surname)
                .accountBalance(BigDecimal.valueOf(5000))
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .fin(fin)
                .birthday(birthdate)
                .cart(Cart.builder().products(new ArrayList<>()).build())
                .build();

        return user;



    }

    public static void checkUserAccount(User user, BigDecimal totalAmount) {
        if (user.getAccountBalance().doubleValue() < totalAmount.doubleValue()){
            throw new ApplicationException(ExceptionEnums.LOW_MONEY_EXCEPTION);
        }
    }

        static UserService userService = new IUserService();
        static UserManagement userManagement = new IUserManagement();
        static AdminManagement adminManagement = new IAdminManagement();



        public static void login() {
            System.out.println("-------------| Welcome to Login Menu |--------------");
            String email = InputUtil.getInstance().inputString("Enter the email: ");
            String password = InputUtil.getInstance().inputString("Enter the password: ");

            List<User> users = userService.findAll();

            User userIsExist = users.stream()
                    .filter(user -> user.getEmail().equals(email))
                    .filter(user -> user.getPassword().equals(password))
                    .findFirst().orElseThrow(() -> new ApplicationException(ExceptionEnums.USER_NOT_FOUND));

            userManagement.manage(userIsExist);

        }

        public static void signIn() {
            System.out.println("-------------|  Sign Up Menu |--------------");
            User user = ServiceHelper.fillUser();

            userService.createUser(user);
            userManagement.manage(user);
        }

        public static void adminLogin() {
            String username = InputUtil.getInstance().inputString("Enter the username: ");
            String password = InputUtil.getInstance().inputString("Enter the password: ");
            if(username.equals(Constant.ADMIN_USERNAME) && password.equals(Constant.ADMIN_PASSWORD)){
                adminManagement.manage();
            }else {
                throw new ApplicationException(ExceptionEnums.WRONG_USERNAME_OR_PASSWORD_EXCEPTION);
            }
        }
}


