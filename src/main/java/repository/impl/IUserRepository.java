package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.User;
import model.enums.ExceptionEnum;
import model.exception.GeneralException;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class IUserRepository extends RepositoryConfig implements UserRepository {
    @Override
    public int createUser(User user) {

        try {
            getEntityTransaction().begin();
            getEntityManager().persist(user);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.PERSIST_UNSUCCESSFULLY);
        }
        return 1;


    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> findAll = getEntityManager().createNamedQuery("findAllUser", User.class);
        return findAll.getResultList();
    }


    @Override
    public Optional<User> findById(long id) {
        getEntityManager().find(User.class, id);
        return Optional.ofNullable(getEntityManager().find(User.class, id));
    }

    @Override
    public int update(User user) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(user);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY);
        }


        return 1;
    }

}
