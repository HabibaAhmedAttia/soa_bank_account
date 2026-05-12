package com.example.cashier.controller;

import com.example.cashier.entity.FoodItem;
import com.example.cashier.entity.Order;
import com.example.cashier.entity.OrderItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    private List<FoodItem> foodItems=new ArrayList<>();
    private Map<Integer, List<OrderItem>> orders = new HashMap<>();
    @PostMapping("/add-food-item")
    public String addFoodItem(@RequestBody FoodItem foodItem){
        for(FoodItem item:foodItems){
            if(foodItem.getId()== item.getId()||foodItem.getName()==item.getName()){
                return foodItem.getName()+" already exists";
            }
        }
        if(foodItem.getPrice()<=0){
            return "invalid price";
        }
        foodItems.add(foodItem);
        return "FoodItem "+foodItem.getName()+" added successfully with price "+foodItem.getPrice();
    }
    @GetMapping("/show-menu")
    public List<FoodItem> showMenu(){
        return foodItems;
    }
    @PostMapping("/create-order")
    public String createOrder(@RequestBody Map<String, Object> request) {
        int orderId = (int) request.get("orderId");
        if (orders.containsKey(orderId)) {
            return "Order already exists with id: " + orderId;
        }
        List<Map<String, Object>> items = (List<Map<String, Object>>) request.get("items");
        List<OrderItem> orderItemList = new ArrayList<>();
        for (Map<String, Object> item : items) {
            int foodId = (int) item.get("foodId");
            int quantity = (int) item.get("quantity");
            FoodItem food = null;
            for (FoodItem f : foodItems) {
                if (f.getId() == foodId) {
                    food = f;
                    break;
                }
            }
            if (food == null) {
                return "Food not found with id: " + foodId;
            }
            if (quantity <= 0) {
                return "Invalid quantity for foodId: " + foodId;
            }
            orderItemList.add(new OrderItem(orderId,food, quantity));
        }
        orders.put(orderId, orderItemList);
        return "Order " + orderId + " created successfully";
    }
    @DeleteMapping("/order/{orderId}/item/{foodId}")
    public String removeItem(@PathVariable int orderId, @PathVariable int foodId) {
        List<OrderItem> items = orders.get(orderId);
        if (items == null) {
            return  "Order not found";
        }
        boolean removed = items.removeIf(item -> item.getFoodItem().getId() == foodId);
        if (!removed) {
            return "Item not found in order";
        }
        if (items.isEmpty()) {
            orders.remove(orderId);
            return "Order is empty and deleted";
        }
        return "order item with id "+foodId+" deleted successfully";
    }
    @GetMapping("/order/{orderId}")
    public Map<String, Object> getOrder(@PathVariable int orderId) {
        List<OrderItem> items = orders.get(orderId);
        if (items == null) {
            return Map.of("message", "Order not found");
        }
        double total = 0;
        List<Map<String, Object>> result = new ArrayList<>();
        for (OrderItem item : items) {
            double subTotal = item.getFoodItem().getPrice() * item.getQuantity();
            total += subTotal;
            result.add(Map.of(
                    "name", item.getFoodItem().getName(),
                    "quantity", item.getQuantity(),
                    "price", item.getFoodItem().getPrice(),
                    "subTotal", subTotal
            ));
        }
        return Map.of(
                "orderId", orderId,
                "items", result,
                "totalPrice", total
        );
    }
    @GetMapping("/receipt/{orderId}")
    public Map<String, Object> showReceipt(@PathVariable int orderId) {
        List<OrderItem> items = orders.get(orderId);
        if (items == null) {
            return Map.of("message", "Order not found");
        }
        double total = 0;
        List<Map<String, Object>> result = new ArrayList<>();
        for (OrderItem item : items) {
            double subTotal = item.getFoodItem().getPrice() * item.getQuantity();
            total += subTotal;
            Map<String, Object> obj = new HashMap<>();
            obj.put("name", item.getFoodItem().getName());
            obj.put("quantity", item.getQuantity());
            obj.put("price", item.getFoodItem().getPrice());
            obj.put("subTotal", subTotal);
            result.add(obj);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", orderId);
        response.put("items", result);
        response.put("totalPrice", total);
        return response;
    }
}























