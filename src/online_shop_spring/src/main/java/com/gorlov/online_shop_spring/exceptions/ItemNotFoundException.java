package com.gorlov.online_shop_spring.exceptions;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(long userId) {
        super(String.format("Item is not found with id : '%s'", userId));
    }
}
