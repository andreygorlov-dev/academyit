package com.gorlov.online_shop_spring.exceptions;

public class CategoryNotFoundException extends Exception {

    public CategoryNotFoundException(long userId) {
        super(String.format("Category is not found with id : '%s'", userId));
    }

}
