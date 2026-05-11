package org.example;

import java.util.Scanner;

public class UserFunctions {
    static int enterNumber(String transaction) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (true) {
            System.out.println(transaction);
            try {
                number = sc.nextInt();
                if (number <= 0) {
                    System.out.println("enter positive number");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.println("Enter valid number!");
                sc.nextLine();
            }
        }
    }
    public static int chooseTransaction() {
        System.out.println("choose your transaction:");
        int transaction=0;
        try {
            System.out.println("1.withdraw");
            System.out.println("2.deposite");
            System.out.println("3.show my balance");
            System.out.println("4.show history");
            Scanner sc = new Scanner(System.in);
            transaction = sc.nextInt();

        } catch (Exception e) {
            System.out.println("enter 1 or 2 or 3");
        }
        return transaction;
    }
}
