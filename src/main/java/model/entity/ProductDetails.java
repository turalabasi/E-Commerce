package model.entity;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.ToString;

@Builder
@Embeddable
@ToString
public class ProductDetails {
    String color;
    String size ;

    public ProductDetails(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public ProductDetails() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
