package com.gorlov.online_shop_spring.controllers;

import com.gorlov.online_shop_spring.exceptions.ItemNotFoundException;
import com.gorlov.online_shop_spring.models.Item;
import com.gorlov.online_shop_spring.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping(value = "/item")
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @GetMapping(value = "/item/{id}")
    public Item getItemById(@PathVariable(name = "id") long id) throws ItemNotFoundException {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @GetMapping(value = "/category/{id}/item")
    public List<Item> getItemByCategoryId(@PathVariable(name = "id") long id){
        return itemRepository.findAllItemByCategoryId(id);
    }

    /**
     * Пример запроса
     * <pre>
     *     {
     *     "title" : "Приключение Алисы",
     *     "description" : "Книга написана Киром Булычёвым",
     *     "price" : "123",
     *     "count" : "19",
     *     "category" : {
     *         "id" : 1
     *     }
     * }
     * </pre>
     * @param item
     * @return
     */
    @PostMapping(value = "/item")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody Item item) {
        itemRepository.save(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Обновляем только колличество товара или цену
     */
    @PutMapping(value = "/item/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable(name = "id") long id, @RequestBody Item item) throws Exception {
        if (item.getPrice() == null && item.getCount() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Item itemUpdate = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));


        if (item.getPrice() != null) {
            itemUpdate.setPrice(item.getPrice());
        }

        if (item.getCount() != null) {
            itemUpdate.setCount(item.getCount());
        }

        itemRepository.save(itemUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/item/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") long id) throws ItemNotFoundException {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        itemRepository.delete(item);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
