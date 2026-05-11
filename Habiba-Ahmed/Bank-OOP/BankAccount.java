package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccount {
    private int balance;
    private int withDrawLimit = 500;
    private List<List<Integer>> list = new ArrayList<>();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int withdraw(BankAccount bankAccount, int amount) {
        if (amount > bankAccount.getBalance()) {
            System.out.println("your balance is less than withdraw amount");
        } else {
            if (withDrawLimit - amount < 0) {
                System.out.println("you exceed your withdraw limit for today");
            } else {
                if (list.isEmpty()) {
                    list.add(new ArrayList<>());
                    list.add(new ArrayList<>());
                }
                list.get(0).add(amount);
                withDrawLimit -= amount;
                bankAccount.setBalance(bankAccount.getBalance() - amount);
                System.out.println("your balance now is " + bankAccount.getBalance());
                System.out.println("==============================================");
            }
        }

        return amount;
    }

    public void deposite(BankAccount bankAccount, int amount) {
        if (amount <= 0) {
            System.out.println("enter valid deposite amount");
        } else {
            if (list.isEmpty()) {
                list.add(new ArrayList<>());
                list.add(new ArrayList<>());
            }
            list.get(1).add(amount);
            bankAccount.setBalance(bankAccount.getBalance() + amount);
            System.out.println("your balance now is " + bankAccount.getBalance());
            System.out.println("==============================================");
        }
    }

    public void showHistory() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (i == 0) {
                    System.out.print("withdraw  ");
                } else {
                    System.out.print("deposite  ");
                }
                System.out.println(list.get(i).get(j));
            }
        }
        System.out.println("==============================================");
    }

    public void searchOnSpecificOperation(String operation) {
        if (operation.equals("withdraw")) {
            for (int i = 0; i < list.get(0).size(); i++) {
                System.out.println("withdraw  " + list.get(0).get(i));
            }
        } else if (operation.equals("deposite")) {
            for (int i = 0; i < list.get(1).size(); i++) {
                System.out.println("deposite  " + list.get(1).get(i));
            }
        }
        System.out.println("==============================================");
    }
}
