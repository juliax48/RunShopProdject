package com.runshop.controller.rest;

import com.runshop.entity.Item;
import com.runshop.service.serviceItem.ItemService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/items")
public class ItemsRestController {

    private static final Logger log = Logger.getLogger(ItemsRestController.class);

    ItemService itemService;

    @GetMapping()
    public ResponseEntity<Object> findAllItems() {
        List<Item> allItems = itemService.findAll();
        return new ResponseEntity(allItems, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findItemById(@PathVariable Long id) {
        Item item = itemService.findById(id);
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @GetMapping("/search-brand")
    public ResponseEntity<Item> searchItemsByBrand(@RequestParam("brand") String brand){
        List<Item> listBrand = itemService.searchItemsByBrand(brand);
        return new ResponseEntity(listBrand, HttpStatus.OK);
    }
    @GetMapping("/search-size")
    public ResponseEntity<Item> searchItemsBySize(@RequestParam("size") Double size){
        List<Item> Objects = itemService.searchItemsBySize(size);
        return new ResponseEntity(Objects, HttpStatus.OK);
    }






    @PostMapping("")
    public ResponseEntity<Item> createItem(@RequestBody ItemCreateRequest request) {
        Item buildItem = Item.builder()
                .name(request.getName())
                .brand(request.getBrand())
                .size(request.getSize())
                .color(request.getColor())
                .price(request.getPrice())
                .build();
        Item createdItem = itemService.create(buildItem);
                return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Item> updateItem(@RequestBody ItemCreateRequest request) {
        Item updateItem = Item.builder()
                .id(request.getId())
                .name(request.getName())
                .brand(request.getBrand())
                .size(request.getSize())
                .color(request.getColor())
                .price(request.getPrice())
                .build();
        Item updatedItem = itemService.update(updateItem);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItemById(@PathVariable Long id) {
        Item deleteItemById = itemService.delete(id);
        return new ResponseEntity<>(deleteItemById, HttpStatus.OK);
    }

}