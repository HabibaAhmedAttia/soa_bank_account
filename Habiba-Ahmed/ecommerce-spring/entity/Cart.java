package com.example.shop.entity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private User user;
    Map<String, Integer> productAmountInCard = new HashMap<>();
    private ArrayList<Product> cartProducts;
    public Cart() {
        this.cartProducts = new ArrayList<>();
        this.productAmountInCard = new HashMap<>();
    }
    public ArrayList<Product> getCartProducts() {
        return cartProducts;
    }

}
