package com.gorlov.online_shop_spring.repositories;

import com.gorlov.online_shop_spring.models.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepositoryCustom {

    @Query("SELECT i FROM Item i WHERE i.category.id = ?1")
    List<Item> findAllItemByCategoryId(long id);

}
