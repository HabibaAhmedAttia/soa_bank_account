package com.example.shop.entity;

public class Product {
    private String name;
    private double price;
    private int quantity;
//    private int userAmount;

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

//    public int getUserAmount() {
//        return userAmount;
//    }
//
//    public void setUserAmount(int userAmount) {
//        this.userAmount = userAmount;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
