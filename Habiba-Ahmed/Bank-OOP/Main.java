package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {        
        int balance=UserFunctions.enterNumber("enter your balance");
        BankAccount bankAccount=new BankAccount(balance);
        int transaction=0;
        while (true){
            transaction=UserFunctions.chooseTransaction();
            if (transaction == 1) {
                int amount = UserFunctions.enterNumber("enter withdraw amount");
                bankAccount.withdraw(bankAccount, amount);
            } else if (transaction == 2) {
                int amount = UserFunctions.enterNumber("enter deposite amount");
                bankAccount.deposite(bankAccount, amount);
            } else if (transaction == 3) {
                System.out.println("Your balance is "+bankAccount.getBalance());
            }
            else if (transaction == 4) {
                bankAccount.showHistory();
                System.out.println("enter specific operation");
                Scanner sc=new Scanner(System.in);
                String operation=sc.nextLine();
                bankAccount.searchOnSpecificOperation(operation);
            }
            
            else{
                System.out.println("enter 1 or 2 or 3 or 4 to choose your transaction-");
            }
        }
    }
}

