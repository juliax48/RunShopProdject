package com.runshop.controller.rest;


import lombok.*;
import org.springframework.stereotype.Controller;

@Controller
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ItemCreateRequest {
    private Long id;
    private String name;

    private String brand;

    private Double size;

    private String color;

    private Double price;

}
