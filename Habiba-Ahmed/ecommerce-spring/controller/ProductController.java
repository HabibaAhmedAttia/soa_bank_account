package com.example.shop.controller;

import com.example.shop.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Product")
public class ProductController {
    ArrayList<Product> products=new ArrayList<>();
    @PostMapping
    public String addProduct(@RequestBody Product product){
        products.add(product);
        return "product added successfully";
    }
    @GetMapping
    public ArrayList<Product> showProducts(){
        return products;
    }
}
