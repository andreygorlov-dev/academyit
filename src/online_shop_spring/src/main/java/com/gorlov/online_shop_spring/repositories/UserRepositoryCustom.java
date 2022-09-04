package com.gorlov.online_shop_spring.repositories;

import com.gorlov.online_shop_spring.models.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositoryCustom {

    @Query(value = "SELECT u FROM User u WHERE u.login = ?1")
    User getByLogin(String login);

}
