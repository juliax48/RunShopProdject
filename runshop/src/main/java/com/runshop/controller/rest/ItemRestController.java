package com.runshop.controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemRestController {
    @GetMapping("/hello-world")
    public String sayHello() {
        return "Hello word";
    }

}


//объеты в Json формат
//еще однин контрллер ItemViewCotroller как доп
