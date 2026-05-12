package com.example.cashier.entity;

import java.util.List;

public class Order {
    private int id;
    private List<OrderItem> orderItems;
    private double totalPrice;
    public Order() {
    }

    public Order( List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
