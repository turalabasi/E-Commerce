package model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Builder
@NamedQueries({
        @NamedQuery(name = "findAllProduct",query = "SELECT c FROM Product c"),
        @NamedQuery(name = "findByName",query = "SELECT c FROM Product c WHERE c.name =:name")})
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(updatable = false,nullable = false,name = "pruduct_name")
    private String name;
    @Column(nullable = false,name = "product_price")
    private BigDecimal price;
    @Column(updatable = false,nullable = false,name = "product_description")
    private String description;
    @Column(nullable = false,name = "product_remainCount")
    private Long remainCount ;
    @Column(nullable = false,name = "product_stars")
    private byte star ;

    @Column(nullable = false,name = "product_likes")
    private byte likes ;


    @Column(nullable = false,name = "product_status")
    private boolean status;

    @ElementCollection
    private List<String> comment;

    @ManyToOne(fetch = FetchType.LAZY)
    Brand brand;

    @ManyToOne
    private Category category;

    @Embedded
    ProductDetails productDetails;

    public void addComment(String comment) {
        this.comment.add(comment);
    }



    public void setStar(byte star) {
        if(star > 5){
            this.star = (byte) ((byte) (this.star + 5) / 2);
        }else {
            this.star = (byte) ((byte) (this.star + star) / 2);
        }
    }

    public Product(Long id, String name, BigDecimal price, String description, Long remainCount, byte star, byte likes, boolean status, List<String> comment, Brand brand, Category category, ProductDetails productDetails) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.remainCount = remainCount;
        this.star = star;
        this.likes = likes;
        this.status = status;
        this.comment = comment;
        this.brand = brand;
        this.category = category;
        this.productDetails = productDetails;
    }

    public void decreaseRemainCount(){
        --remainCount;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Long remainCount) {
        this.remainCount = remainCount;
    }

    public byte getStar() {
        return star;
    }



    public byte getLikes() {
        return likes;
    }

    public void setLikes(byte likes) {
        this.likes = likes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }
}