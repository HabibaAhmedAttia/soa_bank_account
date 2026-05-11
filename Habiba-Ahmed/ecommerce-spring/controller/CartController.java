package com.example.shop.controller;

import com.example.shop.entity.Cart;
import com.example.shop.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Cart")
public class CartController {
    Map<String, Integer> productAmountInCard = new HashMap<>();
    @PostMapping("/addProductToCart")
    public String addProductToCart(@RequestBody Product product, @RequestParam int amount){
        productAmountInCard.put(product.getName(),amount);
        product.setQuantity(product.getQuantity()-amount);
        return "product added to cart with amount "+amount;
    }
        @DeleteMapping
    public void removeProductFromCart(@RequestBody Product product,@RequestParam int amount){
//        productAmountInCard.remove()
        product.setQuantity(product.getQuantity()+amount);
    }
    @GetMapping("/totalPrice")
    public double getTotalPriceForCart(){
        double price=0;
//        for(Product product: cartProducts){
//            int intVal=productAmountInCard.get(product).intValue();
//            price+=(product.getPrice()*intVal);
//        }
        return price;
    }
    @GetMapping("/showProductsOnCart")
    public ArrayList<Product> showProductsInCart(@RequestBody Cart cart) {
        return cart.getCartProducts();
    }
}
