package com.gorlov.online_shop_spring.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ITEM")
@Data
public class Item {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column(unique=true)
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private Double price;

    @NotBlank
    private Integer count;

    @ManyToOne
    private Category category;

    public void setCount(Integer count) throws Exception {
        if (count < 0) {
            throw new Exception("Quantity of goods cannot be less than 0");
        }
        this.count = count;
    }

    public void setPrice(Double price) throws Exception {
        if (price < 0d) {
            throw new Exception("Product price cannot be less than 0");
        }
        this.price = price;
    }
}
