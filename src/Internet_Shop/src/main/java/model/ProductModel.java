package model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMG")
    private String img;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CATEGORY_ID")
    private long categoryId;

    public ProductModel() {
    }

    public ProductModel(long id, String title, String description, String img, Double price, long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.img = img;
        this.price = price;
        this.categoryId = categoryId;
    }

    public ProductModel(String title, String description, String img, Double price, long categoryId) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.price = price;
        this.categoryId = categoryId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public Double getPrice() {
        return price;
    }

    public long getCategoryId() {
        return categoryId;
    }
}
