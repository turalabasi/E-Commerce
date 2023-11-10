package repository.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import model.config.RepositoryConfig;
import model.entity.Trendyol;
import repository.TrendyolRepository;

public class ITrendyolRepository extends RepositoryConfig implements TrendyolRepository {
    @Override
    public Trendyol findCompanyById(long id) {
        return getEntityManager().find(Trendyol.class,id);
    }

    @Override
    public void updateCompany(Trendyol company) {
        try {
            getEntityTransaction().begin();
            getEntityManager().merge(company);
            getEntityTransaction().commit();
        }catch (Exception e){
            getEntityTransaction().rollback();
            throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
        }
    }
}

