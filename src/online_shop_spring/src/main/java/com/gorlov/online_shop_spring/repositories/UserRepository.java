package com.gorlov.online_shop_spring.repositories;

import com.gorlov.online_shop_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
