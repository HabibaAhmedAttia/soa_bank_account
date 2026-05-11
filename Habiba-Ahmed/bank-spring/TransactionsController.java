package com.example.Bank_Account.controller;

import com.example.Bank_Account.entity.BankAccount;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class TransactionsController {
    private BankAccount bankAccount=new BankAccount();
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int amount) {
        if(!bankAccount.isFreeze()){
            if (amount > bankAccount.getBalance()) {
                System.out.println("your balance is less than withdraw amount");
            } else {
                if (bankAccount.getWithDrawLimit() - amount < 0) {
                    return "you exceed your withdraw limit for today";
                } else {
                    if (bankAccount.getList().isEmpty()) {
                        bankAccount.getList().add(new ArrayList<>());
                        bankAccount.getList().add(new ArrayList<>());
                    }
                    bankAccount.getList().get(0).add(amount);
                    bankAccount.setWithDrawLimit(bankAccount.getWithDrawLimit()-amount);
                    bankAccount.setBalance(bankAccount.getBalance() - amount);
                }
            }
            return "you withdrawed " + amount + " successfully and your balance now is "+bankAccount.getBalance();
        }
        return "your account has been freezed";
    }
    @PostMapping("/deposite")
    public String deposite(@RequestParam int amount) {

        if(!bankAccount.isFreeze()){
            if (amount <= 0) {
                return "enter valid deposite amount";
            } else {
                if (bankAccount.getList().isEmpty()) {
                    bankAccount.getList().add(new ArrayList<>());
                    bankAccount.getList().add(new ArrayList<>());
                }
                bankAccount.getList().get(1).add(amount);
                bankAccount.setBalance(bankAccount.getBalance() + amount);

            }
            return "you depositted " + amount + " successfully and your balance now is "+bankAccount.getBalance();
        }
        return "your account has been freezed";
    }
    @PostMapping("/toggle")
    public String toggleFreezed(@RequestParam boolean status){
        bankAccount.setfreeze(status);
        if(status==true){
            return "freezed";
        }
        return "unfreezed";
    }
    @GetMapping("/ShowHistory")
    public List showHistory() {
        if(!bankAccount.isFreeze()){
            List<String>history=new ArrayList<>();
            if (bankAccount.getList() == null || bankAccount.getList().isEmpty()) {
                return history;
            }
            for (int i = 0; i < bankAccount.getList().get(0).size(); i++) {
                history.add("withdraw " + bankAccount.getList().get(0).get(i));
            }
            if (bankAccount.getList().size() > 1) {
                for (int i = 0; i < bankAccount.getList().get(1).size(); i++) {
                    history.add("deposit " + bankAccount.getList().get(1).get(i));
                }
            }
            return history;
        }

        return List.of("account has been freezed");
    }
    @GetMapping("/SearchOnSpecificOperation")
    public List<String> searchOnSpecificOperation(@RequestParam String operation) {
        if(!bankAccount.isFreeze()){
            List<String> result = new ArrayList<>();
            if (bankAccount.getList() == null || bankAccount.getList().isEmpty()) {
                return result;
            }
            if ("withdraw".equals(operation)) {
                for (int i = 0; i < bankAccount.getList().get(0).size(); i++) {
                    result.add("withdraw " + bankAccount.getList().get(0).get(i));
                }
            } else if ("deposite".equals(operation)) {
                if (bankAccount.getList().size() > 1) {
                    for (int i = 0; i < bankAccount.getList().get(1).size(); i++) {
                        result.add("deposite " + bankAccount.getList().get(1).get(i));
                    }
                }
            }
        }
        return List.of("account has been freezed");
    }

}
