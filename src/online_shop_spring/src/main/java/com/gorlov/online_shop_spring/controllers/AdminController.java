package com.gorlov.online_shop_spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    /**
     * Не понятно что значит отгрузка товаров
     * Для реализации этой части задания
     * <pre>
     *     Пользователь API может вызвать защищенный метод отгрузки
     *     товаров, который доступен только пользователям, у которых есть apikey
     * </pre>
     * Создаю-метод заглушку, к которому имеют доступ те, кто указал api-key
     */
    @GetMapping(value = "shipment")
    public String shipment() {
        return "Товар отгружен";
    }
}
