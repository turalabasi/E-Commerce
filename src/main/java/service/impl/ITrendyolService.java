package service.impl;

import model.entity.Trendyol;
import repository.TrendyolRepository;
import repository.impl.ITrendyolRepository;
import service.TrendyolService;

import java.math.BigDecimal;

public class ITrendyolService implements TrendyolService {
    TrendyolRepository companyRepository = new ITrendyolRepository();
    @Override
    public Trendyol findCompany() {
        return companyRepository.findCompanyById(1);
    }

    @Override
    public void updateAccountCompany(BigDecimal price) {

        Trendyol company = findCompany();
        BigDecimal newPrice = company.getAccountBalance().add(price);
        company.setAccountBalance(newPrice);
        companyRepository.updateCompany(company);

    }
}

