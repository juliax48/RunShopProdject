package com.runshop.controller.mvc;

import com.runshop.entity.Item;
import com.runshop.service.serviceItem.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET) //ключ
    public ModelAndView findAllUsers() {

        List<Item> itemList = itemService.findAll();

        String collect = itemList.stream().map(Item::getName)
                .collect(Collectors.joining(","));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemName", collect);
        modelAndView.addObject("items", itemList);

        modelAndView.setViewName("hello");

        return modelAndView;
    }
}

//    GET + /users = findAllUsers
//    GET + /users/1 = findUserById
//    POST + /users = createUser
