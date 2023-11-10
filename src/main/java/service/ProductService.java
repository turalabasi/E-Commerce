package service;

import model.entity.Product;

import java.util.List;

public interface ProductService {
    void showAllProduct();
    Product findById(String title,boolean isProductService);
    void updateProduct(Product product,String comment,int star);
    void saveProduct();
    void updateProductForAdmin();
    void deleteProduct();
    void findByName();
    void decreaseRemainCount(List<Product> products);

}
