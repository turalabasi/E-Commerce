package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import helper.ServiceHelper;
import model.entity.Product;
import repository.ProductRepository;
import repository.impl.IProductRepository;
import service.ProductService;
import util.InputUtil;

import java.util.List;

import static helper.ServiceHelper.fillProduct;

public class IProductService implements ProductService {
    ProductRepository productRepository = new IProductRepository();

    @Override
    public void showAllProduct() {
        productRepository.findAll()
                .forEach(System.out::println);
    }

    @Override
    public Product findById(String title, boolean isProductService) {
        long id = InputUtil.getInstance().inputLong("Choose product id for " + title + ": ");
        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionEnums.PRODUCT_NOT_FOUND));
        if (isProductService) {
            System.out.println(product);
        }
        return product;
    }



    @Override
    public void updateProduct(Product product, String comment, int star) {

        product.addComment(comment);

        if (star > 5) {
            product.setStar((byte) 5);
        } else {
            product.setStar((byte) star);
        }

        productRepository.update(product);

    }

    @Override
    public void saveProduct() {
        Product product = fillProduct();

        productRepository.createProduct(product);
    }

    @Override
    public void updateProductForAdmin() {
        showAllProduct();

        long id = InputUtil.getInstance().inputLong("Enter the product id for update: ");
        Product product = productRepository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionEnums.PRODUCT_NOT_FOUND));

        Product updateProduct = ServiceHelper.updateProduct(product);

        productRepository.update(updateProduct);


    }

    @Override
    public void deleteProduct() {
        showAllProduct();

        long id = InputUtil.getInstance().inputLong("Enter the product id for delete: ");

        Product product = productRepository.findById(id).orElseThrow(() -> new  ApplicationException(ExceptionEnums.PRODUCT_NOT_FOUND));
        product.setStatus(false);

        productRepository.update(product);

    }

    @Override
    public void findByName() {
        String name = InputUtil.getInstance().inputString("Enter the product name: ");
        List<Product> products = productRepository.findByName(name);
        products
                .forEach(System.out::println);

    }



    @Override
    public void decreaseRemainCount(List<Product> products) {

        products.stream()
                .peek(Product::decreaseRemainCount)
                .forEach(productRepository::update);


    }
}
