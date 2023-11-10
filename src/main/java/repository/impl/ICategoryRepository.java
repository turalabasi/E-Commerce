package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Category;
import model.enums.ExceptionEnum;
import model.exception.GeneralException;
import repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class ICategoryRepository extends RepositoryConfig implements CategoryRepository {


    @Override
    public int createCategory(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().persist(category);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.PERSIST_UNSUCCESSFULLY);
        }
        return 1;
    }

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> findAll = getEntityManager().createNamedQuery("findAllCategory", Category.class);
        return findAll.getResultList();
    }

    @Override
    public List<Category> findByName(String name) {
        TypedQuery<Category> findByName = getEntityManager().createNamedQuery("findByName", Category.class);
        findByName.setParameter("name", name);

        return findByName.getResultList();
    }

    @Override
    public Optional<Category> findById(long id) {
        getEntityManager().find(Category.class, id);
        return Optional.ofNullable(getEntityManager().find(Category.class, id));
    }

    @Override
    public void delete(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().remove(category);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY);
        }

    }

    @Override
    public int update(Category category) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(category);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY);
        }
        return 1;
    }


}

