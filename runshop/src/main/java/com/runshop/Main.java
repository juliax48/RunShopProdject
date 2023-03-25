package com.runshop;

import com.runshop.entity.Item;
import com.runshop.repository.implementItem.ItemRepositoryImpl;
import com.runshop.repository.implementUser.EntityNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) throws EntityNotFoundException {
        ItemRepositoryImpl itemRepository = new ItemRepositoryImpl(new JdbcTemplate());


        System.out.println("-------------------------------------------------------------------------");
        List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            System.out.println(item);
        }

//        List<Item> itemList = itemRepository.findAll();
//        for (Item item : itemList) {
//            System.out.println(item);
//        }
//        System.out.println("--------------");
//        Item item = Item.builder().brand("REEE").name("TDDD").size("XS").color("Red").price(34D).build();
//        System.out.println("--------------");
//        System.out.println(itemRepository.findById(1L));
//        System.out.println("--------------");
//        System.out.println(itemRepository.create(item));
//        System.out.println("--------------");
//        Item item1 = Item.builder().id(3L).brand("XXX").name("XXX").size("XXX").price(50D).color("RRRR").build();
//        System.out.println(itemRepository.update(item1));
//




    }
}