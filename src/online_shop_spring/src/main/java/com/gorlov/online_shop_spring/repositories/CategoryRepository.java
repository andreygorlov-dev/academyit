package com.gorlov.online_shop_spring.repositories;

import com.gorlov.online_shop_spring.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
