package org.javapractice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int atmPIN = 12345;
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Bank ATM");
        System.out.println("Enter PIN: ");
        int pin = s.nextInt();

        if(atmPIN == pin){
            BankAccount account1 = new BankAccount("Garfield", "01");
            account1.showMenu();

        }else{
            System.out.println("Incorrect pin");
            System.exit(0);
        }
    }
}












