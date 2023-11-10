package repository;

import model.entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository {
    int createBrand(Brand brand);
    List<Brand> findAll();
    List<Brand> findByName(String name);
    Optional<Brand> findById(long id);
    void delete(Brand brand);
    int update(Brand brand);
}
