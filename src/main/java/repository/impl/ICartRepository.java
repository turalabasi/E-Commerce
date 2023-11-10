package repository.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import model.config.RepositoryConfig;
import model.entity.Cart;
import repository.CartRepository;

public class ICartRepository extends RepositoryConfig implements CartRepository {

    @Override
    public void updateProductToCart(Cart cart) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(cart);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
        }
    }

    @Override
    public void buyProductsInCart(Cart cart) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(cart);
            getEntityTransaction().commit();
        }catch (Exception e){
            throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION );
        }
    }
    }

