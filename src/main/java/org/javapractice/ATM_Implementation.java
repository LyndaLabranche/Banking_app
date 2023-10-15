package org.javapractice;

import java.util.Map;
import java.util.Scanner;

public class ATM_Implementation implements ATM_Interface {
    BankAccount account1 = new BankAccount("Garfield", "01");

    @Override
    public double availableBalance() {
        return account1.getBalance();
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            account1.setDepositAmount(amount);
            account1.setPreviousTransactions(true);
            account1.setBalance(account1.getBalance() + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount < account1.getBalance()){
            if (amount > 0 && amount % 20 == 0 || amount % 50 == 0 || amount % 100 == 0 ) {
                account1.setWithdrawAmount(amount);
                account1.setPreviousTransactions(false);
                account1.setBalance(account1.getBalance() - amount);
            }else {
                System.out.println("Please ENTER amount in multiples of 20, 50, or 100");
            }
        }else{
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void displayPreviousTransactions() {
        if (!account1.getPreviousTransactions().isEmpty()) {
            for (Map.Entry<String, Object> t : account1.getPreviousTransactions().entrySet()) {
                System.out.println(t.getKey() + " " + t.getValue());
            }
        } else{
                System.out.println("No recent transaction.");
        }
    }

    @Override
    public void showMenu() {
        char option;
        Scanner s = new Scanner(System.in);

        System.out.println("Hello, " + account1.getCustomerName() + "!");
        System.out.println("Your ID is: " + account1.getCustomerId());
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
                case 'A' -> {
                    System.out.println("=====================================");
                    System.out.println("Available Balance: " + this.availableBalance());
                    System.out.println("=====================================");
                    System.out.println();
                }
                case 'B' -> {
                    System.out.println("=====================================");
                    System.out.println("Enter amount to deposit:");
                    System.out.println("=====================================");
                    double amount = s.nextDouble();
                    this.deposit(amount);
                    this.availableBalance();
                    System.out.println();
                }
                case 'C' -> {
                    System.out.println("=====================================");
                    System.out.println("Enter amount to withdraw:");
                    System.out.println("=====================================");
                    double amount2 = s.nextInt();
                    this.withdraw(amount2);
                    this.availableBalance();
                    System.out.println();
                }
                case 'D' -> {
                    System.out.println("=====================================");
                    this.displayPreviousTransactions();
                    System.out.println("=====================================");
                    System.out.println();
                }
                case 'E' -> {
                    System.out.println("*********************************");
                    System.out.println("Please take your card");
                    System.out.println("------->Thank you for banking with us!");
                    System.out.println("*********************************");
                    System.out.println();
                }
                default -> System.out.println("Invalid Option. Please try again!");
            }
        } while (option != 'E');
    }
}



