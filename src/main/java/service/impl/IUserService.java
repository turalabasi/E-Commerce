package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import helper.ServiceHelper;
import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import repository.UserRepository;
import repository.impl.IUserRepository;
import service.*;
import util.InputUtil;

import java.math.BigDecimal;
import java.util.List;

import static model.constant.Constant.*;

public class IUserService implements UserService {
    ProductService productService = new IProductService();
   TrendyolService trendyolService= new ITrendyolService();
    OrderService orderService = new IOrderService();
    CartService cartService = new ICartService();
    UserRepository userRepository = new IUserRepository();

    @Override
    public void showAllProduct() {
        productService.showAllProduct();
    }

    @Override
    public void addProductToCart(User user) {
        showAllProduct();

        Product product = productService.findById(ADD, false);

        Cart cart = user.getCart();

        cartService.addProductToCart(cart, product);

    }

    @Override
    public void deleteProductToCart(User user) {
        if (user.getCart().getProducts().isEmpty()) {
            throw new ApplicationException(ExceptionEnums.PRODUCT_HAS_NOT_BEEN_SELECTED);
        }
        cartService.showAllProductInCart(user);

        Product product = productService.findById(DELETE, false);
        Cart cart = user.getCart();

        cartService.deleteProductToCart(cart, product);

    }

    @Override
    public void buyProductToCart(User user) {
        if (user.getCart().getProducts().isEmpty()) {
            throw new ApplicationException(ExceptionEnums.PRODUCT_HAS_NOT_BEEN_SELECTED);
        }

        Cart cart = user.getCart();

        ServiceHelper.checkUserAccount(user, cart.getAccountBalance());


        cartService.showAllProductInCart(user);

        try {
            Product product = productService.findById(COMMENT_AND_STARS, false);

            String comment = InputUtil.getInstance().inputString("comment: ");
            byte star = Byte.parseByte(InputUtil.getInstance().inputString("Enter star point: "));


            productService.updateProduct(product, comment, star);

        } catch (RuntimeException e) {
            e.printStackTrace();
        }


        productService.decreaseRemainCount(cart.getProducts());

        trendyolService.updateAccountCompany(cart.getAccountBalance());

        updateAccount(user, cart.getAccountBalance());

        orderService.createOrder(user);

        cartService.buyProductsInCart(cart);
        System.out.println(BUYING_SUCCESSFULLY);
    }

    @Override
    public void increaseBalance(User user) {
        BigDecimal balance = BigDecimal.valueOf(Long.parseLong(InputUtil.getInstance().inputString("Enter to increase balance: ")));
        user.setAccountBalance(user.getAccountBalance().add(balance));

    }

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public void updateAccount(User user, BigDecimal price) {
        user.setAccountBalance(user.getAccountBalance().subtract(price));
        userRepository.update(user);
    }
}
