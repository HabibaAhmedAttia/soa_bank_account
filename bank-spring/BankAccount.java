package com.example.Bank_Account.entity;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int balance;
    private int withDrawLimit;
    private List<List<Integer>> list ;
    private boolean freeze = false;

    public boolean isFreeze() {
        return freeze;
    }

    public void setfreeze(boolean freeze) {
        this.freeze = freeze;
    }
    public BankAccount() {
        this.balance = 1000;
        this.withDrawLimit = 500;
        this.list = new ArrayList<>();
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(int withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public List<List<Integer>> getList() {
        return list;
    }

}
