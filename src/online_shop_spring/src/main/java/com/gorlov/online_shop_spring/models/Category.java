package com.gorlov.online_shop_spring.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "CATEGORY")
@Data
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column(unique=true)
    private String title;

}
