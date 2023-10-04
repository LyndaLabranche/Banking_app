package org.javapractice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class BankAccount {
    private double balance;
    private double depositAmnt;
    private double withdrawAmnt;
    int previousTransaction;
    String customerName;
    String customerId;

    public BankAccount(String name, String id) {
        customerName = name;
        customerId = id;
    }

    double availableBalance() {
        return balance;
    }
    void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        DateFormat date_format_obj = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date d = new Date();
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction + " on " + date_format_obj.format(d));
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction) + " on " + date_format_obj.format(d));
        } else {
            System.out.println("No recent transaction.");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println();

        do {
            System.out.println("What would you like to do today?");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            System.out.println();
            System.out.println("=====================================");
            System.out.println("Enter option: ");
            option = Character.toUpperCase(s.next().charAt(0));


            switch (option) {
                case 'A':
                    System.out.println("=====================================");
                    System.out.println("Available Balance: " + availableBalance());
                    System.out.println("=====================================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("=====================================");
                    System.out.println("Enter amount to deposit");
                    System.out.println("=====================================");
                    int amount = s.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("=====================================");
                    System.out.println("Enter amount to withdraw");
                    System.out.println("=====================================");
                    int amount2 = s.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=====================================");
                    getPreviousTransaction();
                    System.out.println("=====================================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("*********************************");
                    System.out.println("<----Please take your card---->");
                    System.out.println("Thank you for banking with us!");
                    System.out.println("*********************************");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid Option. Please try again!");
            }
        } while (option != 'E');
    }
}
