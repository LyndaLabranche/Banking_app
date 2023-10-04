package org.javapractice;

public interface ATM_Interface {
    public double availableBalance();
    public void deposit(int amount);

    public void withdraw(int amount);

    public void getPreviousTransaction();
}