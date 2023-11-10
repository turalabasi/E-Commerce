package repository;

import model.entity.Cart;

public interface CartRepository {
    void updateProductToCart(Cart cart);
    void buyProductsInCart(Cart cart);
}
