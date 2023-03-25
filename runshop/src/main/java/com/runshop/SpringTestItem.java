package com.runshop;


import com.runshop.configuration.SpringConfig;
import com.runshop.repository.implementItem.ItemRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTestItem {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);

        ItemRepository itemRepository = context.getBean("ItemRepositoryImp", ItemRepository.class);

        System.out.println(itemRepository.findAll());

    }
}
