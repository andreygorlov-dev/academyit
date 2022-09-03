package com.gorlov.pledge_ticket.exception;

public class UserAuthException extends Exception {

    public UserAuthException() {
        super("Ошибка авторизации по логину или паролю");
    }
}
