package com.runshop;


import com.runshop.configuration.SpringConfig;
import com.runshop.repository.implementItem.ItemRepository;
import com.runshop.service.serviceItem.ItemService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTestItem {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "runshop");

        ItemRepository itemRepository = context.getBean("itemRepositoryImpl", ItemRepository.class);

        System.out.println(itemRepository.findAll());

    }
}
