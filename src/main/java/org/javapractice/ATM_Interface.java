package org.javapractice;

public interface ATM_Interface {
    double availableBalance();

    void deposit(double amount);

    void withdraw(double amount);

    void displayPreviousTransactions();

    void showMenu();
}