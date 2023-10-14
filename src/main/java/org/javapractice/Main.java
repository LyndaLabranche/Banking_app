package org.javapractice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Bank ATM");
        System.out.println("Enter PIN: ");
        int pin = s.nextInt();

        ATM_Interface display = new ATM_Implementation();
        if(BankAccount.getAtmPIN() == pin){
            display.showMenu();

        }else{
            System.out.println("Incorrect pin");
            System.exit(0);
        }
    }
}












