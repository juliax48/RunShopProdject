package com.runshop.controller.rest;

import com.runshop.entity.Item;
import com.runshop.service.serviceItem.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ItemRestController {

    ItemService itemService;
    @GetMapping("/start")
    public String enter(){
        return "Hello";
    }


    @GetMapping("/items")
    public ResponseEntity<Item> findAll() {
        List<Item> items = itemService.findAll();
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping("/brand")
    public ResponseEntity<Item> searchItemByBrand(String brand) {
        List<Item> items = itemService.searchItemByBrand(brand);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping("/size")
    public ResponseEntity<Item> searchItemBySize(Double size) {
        List<Item> items = itemService.searchItemBySize(size);
        return new ResponseEntity(items, HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<Item> create(@RequestParam Item item) {
        Item newItem = itemService.create(item);

        return new ResponseEntity(newItem, HttpStatus.CREATED);
    }









}

// на каждый метод создать метод (название такие) find all по
//объеты в Json формат
//еще однин контрллер ItemViewCotroller как доп
//@pathVariable