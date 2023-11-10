package service.impl;

import model.entity.Cart;
import model.entity.Product;
import model.entity.User;
import repository.CartRepository;
import repository.impl.ICartRepository;
import service.CartService;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ICartService implements CartService {
    CartRepository cartRepository = new ICartRepository();
    @Override
    public void buyProductsInCart(Cart cart) {
        cart.setProducts(new ArrayList<>());
        cart.setCount(0L);
        cart.setAccountBalance(new BigDecimal(0));
        cartRepository.buyProductsInCart(cart);
    }

    @Override
    public void addProductToCart(Cart cart, Product product) {
        cart.addProducts(product);

        cart.setCount((long) cart.getProducts().size());

        BigDecimal totalAmount = cart.sumProductPrice(cart.getProducts());

        cart.setAccountBalance(totalAmount);

        cartRepository.updateProductToCart(cart);
    }

    @Override
    public void deleteProductToCart(Cart cart, Product product) {
        cart.deleteProducts(product);

        cart.setCount((long) cart.getProducts().size());

        BigDecimal totalAmount = cart.sumProductPrice(cart.getProducts());

        cart.setAccountBalance(totalAmount);

        cartRepository.updateProductToCart(cart);
    }

    @Override
    public void showAllProductInCart(User user) {
        System.out.println(user.getCart().getProducts());

    }
}
