package model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
@Builder
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, name = "cartP_count")
    private Long count;
    @Column(nullable = false, name = "cart_totalAmount")
    private BigDecimal accountBalance;
    @ManyToMany
    private List<Product> products;


    public void addProducts(Product product) {
        this.products.add(product);
    }

    public void deleteProducts(Product product) {
        this.products.remove(product);
    }

    public BigDecimal sumProductPrice( List<Product> products) {
        BigDecimal sum = new BigDecimal(0);

        System.out.println(products.size());
        for (Product product: products) {
            sum = sum.add(product.getPrice());
        }

        return sum;
    }


    public Cart(Long id, Long count, BigDecimal accountBalance, List<Product> products) {
        this.id = id;
        this.count = count;
        this.accountBalance = accountBalance;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}