package repository;

import model.entity.Trendyol;

public interface TrendyolRepository {
    Trendyol findCompanyById(long id);
    void updateCompany(Trendyol company);
}
