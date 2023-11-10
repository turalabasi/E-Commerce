package repository.impl;

import jakarta.persistence.TypedQuery;
import model.entity.Brand;
import model.enums.ExceptionEnum;
import model.exception.GeneralException;
import repository.BrandRepository;
import model.config.RepositoryConfig;

import java.util.List;
import java.util.Optional;

public class IBrandRepository extends RepositoryConfig implements BrandRepository {
    @Override
    public int createBrand(Brand brand) {

        try {
            getEntityTransaction().begin();
            getEntityManager().persist(brand);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.PERSIST_UNSUCCESSFULLY);
        }
        return 1;


}
    @Override
    public List<Brand> findAll() {
        TypedQuery<Brand> findAll = getEntityManager().createNamedQuery("findAllBrand", Brand.class);
        return findAll.getResultList();
    }

    @Override
    public List<Brand> findByName(String name) {
        TypedQuery<Brand> findByName = getEntityManager().createNamedQuery("findByName", Brand.class);
        findByName.setParameter("name",name);

        return findByName.getResultList();
    }

    @Override
    public Optional<Brand> findById(long id) {
        getEntityManager().find(Brand.class,id);
        return Optional.ofNullable(getEntityManager().find(Brand.class,id));
    }

    @Override
    public void delete(Brand brand) {
        try {
            getEntityTransaction().begin();
            getEntityManager().remove(brand);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.DELETE_UNSUCCESSFULLY);
        }
    }

    @Override
    public int update(Brand brand) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(brand);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new GeneralException(ExceptionEnum.UPDATE_UNSUCCESSFULLY);
        }



        return 1;
    }
}
