package service;

import model.entity.Brand;

public interface BrandService {
    void createBrand();
    void findAll();
    void findByName();
    Brand findById();
    void delete();
    void update();
}
