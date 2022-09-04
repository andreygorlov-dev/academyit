package com.gorlov.online_shop_spring.controllers;

import com.gorlov.online_shop_spring.exceptions.CategoryNotFoundException;
import com.gorlov.online_shop_spring.models.Category;
import com.gorlov.online_shop_spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(value = "/category")
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping(value = "/category/{id}")
    public Category getCategoryById(@PathVariable(name = "id") long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PostMapping(value = "/category")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Category category) {
        categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") long id) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));

        categoryRepository.delete(category);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
