package model;

import com.google.gson.Gson;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    public CategoryModel() {
    }

    public CategoryModel(String title) {
        this.title = title;
    }

    public CategoryModel(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
