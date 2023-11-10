package model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "category")
@Builder
@NamedQueries({
        @NamedQuery(name = "findAllCategory",query = "SELECT c FROM Category c"),
        @NamedQuery(name = "findByName",query = "SELECT c FROM Category c WHERE c.name =:name")})
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(updatable = false,nullable = false,name = "category_name")
    private String name;

    @Column(updatable = false,nullable = false,name = "category_description")
    private String description;
    @Builder.Default
    @Column(nullable = false, name = "category_status")
    private boolean status= true;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {

    }

    public Category(Long id, String name, String description, boolean status, List<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
