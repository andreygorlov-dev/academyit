package com.gorlov.online_shop_spring.exceptions;

public class UserAuthException extends Exception {

    public UserAuthException() {
        super("Ошибка авторизации по логину или паролю");
    }
}
