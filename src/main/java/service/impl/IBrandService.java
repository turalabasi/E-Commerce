package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import helper.ServiceHelper;
import model.constant.Constant;
import model.entity.Brand;
import model.enums.ExceptionEnum;
import model.exception.GeneralException;
import repository.BrandRepository;
import repository.impl.IBrandRepository;
import service.BrandService;
import util.InputUtil;

import java.util.Optional;

public class IBrandService implements BrandService {
    private final BrandRepository repository;

    public IBrandService() {
        this.repository = new IBrandRepository();
    }

    @Override
    public void createBrand() {
        Brand brand = ServiceHelper.fillBrand();
        repository.createBrand(brand);
        System.out.println(Constant.SAVED_SUCCESSFULLY);
    }

    @Override
    public void findAll() {
        System.out.println(repository.findAll());
    }

    @Override
    public void findByName() {
       String name = InputUtil.getInstance().inputString("Enter the brand name:");
        System.out.println(repository.findByName(name));
    }

    @Override
    public Brand findById() {
            long id = InputUtil.getInstance().inputLong("Enter the brand id: ");
            Optional<Brand> optionalBrand = repository.findById(id);
            return optionalBrand.orElseThrow(() -> new ApplicationException(ExceptionEnums.BRAND_NOT_FOUND));
        }


    @Override
    public void delete() {
        System.out.println(repository.findAll());
        long id = InputUtil.getInstance().inputLong("Enter the id to delete:");
        Brand brand = repository.findById(id).orElseThrow(() -> new GeneralException(ExceptionEnum.ITEM_NFOUND));
        repository.delete(brand);


    }

    @Override
    public void update() {
        System.out.println(repository.findAll());
        long id = InputUtil.getInstance().inputLong("Enter the id to delete:");
        String description = InputUtil.getInstance().inputString("Enter the decription:");
        Brand brand = repository.findById(id).orElseThrow(() -> new GeneralException(ExceptionEnum.ITEM_NFOUND));
        brand.setDescription(description);
    }
}
