package com.gorlov.online_shop_spring.repositories;

import com.gorlov.online_shop_spring.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {
}
