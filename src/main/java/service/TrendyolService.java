package service;

import model.entity.Trendyol;

import java.math.BigDecimal;

public interface TrendyolService {
    Trendyol findCompany();
    void updateAccountCompany(BigDecimal price);
}
