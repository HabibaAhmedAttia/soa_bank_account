package com.example.cashier.entity;

public class OrderItem {
    private int id;
    private FoodItem foodItem;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(int id, FoodItem foodItem, int quantity) {
        this.id=id;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
