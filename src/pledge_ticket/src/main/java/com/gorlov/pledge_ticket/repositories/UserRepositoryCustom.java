package com.gorlov.pledge_ticket.repositories;

import com.gorlov.pledge_ticket.models.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepositoryCustom {

    @Query(value = "SELECT u FROM User u WHERE u.login = ?1")
    User getByLogin(String login);

}
