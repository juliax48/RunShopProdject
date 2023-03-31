package com.runshop.controller.mvc;

import com.runshop.controller.rest.ItemsRestController;
import com.runshop.entity.Item;
import com.runshop.service.serviceItem.ItemService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private static final Logger log = Logger.getLogger(ItemsRestController.class);

    private final ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAllItems() {

        List<Item> allItems = itemService.findAll();
        String collect = allItems.stream().map(Item::getName).collect(Collectors.joining(","));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemName", collect);
        modelAndView.addObject("items", allItems);

        modelAndView.setViewName("items");

        return modelAndView;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findItemById(@PathVariable String id) {

        Long parsedUserId;

        try {
            parsedUserId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            log.error("Item id: " + id + " cannot be parsed to Long", e);
            parsedUserId = 1L;
        }

        Optional<Item> item = itemService.findOne(parsedUserId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemName", item.get().getName());
        modelAndView.addObject("items", Collections.singletonList(item));

        modelAndView.setViewName("items");

        return modelAndView;
    }

}
