package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Product;
import model.enums.ExceptionEnum;
import model.exception.GeneralException;
import repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class IProductRepository extends RepositoryConfig implements ProductRepository {

    @Override
    public int createProduct(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(product);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.PERSIST_UNSUCCESSFULLY);
        }
        return 1;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> findAll = getEntityManager().createNamedQuery("findAllProduct", Product.class);
        return findAll.getResultList();
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> findByName = getEntityManager().createNamedQuery("findByName", Product.class);
        findByName.setParameter("name", name);

        return findByName.getResultList();
    }

    @Override
    public Optional<Product> findById(long id) {
        getEntityManager().find(Product.class, id);
        return Optional.ofNullable(getEntityManager().find(Product.class, id));
    }

    @Override
    public void delete(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().remove(product);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY);
        }

    }

    @Override
    public int update(Product product) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(product);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY);
        }
        return 1;
    }

}
