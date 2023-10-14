package org.javapractice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class BankAccount {
    private double balance;
    private double depositAmount;
    private double withdrawAmount;
    private String customerName;
    private String customerId;
    private static int atmPIN;

    private final HashMap<String,Object> previousTransactions = new HashMap<>();

    public BankAccount(String name, String id) {
        this.customerName = name;
        this.customerId = id;
        atmPIN = 12345;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return this.depositAmount;
    }

    public void setDepositAmount(double amount1) {
        this.depositAmount = amount1;
        System.out.println(depositAmount + " Successfully deposited!");
    }

    public double getWithdrawAmount() { return this.withdrawAmount;}

    public void setWithdrawAmount(double amount2) {
        withdrawAmount = amount2;
        System.out.println("Please take " + withdrawAmount + " in cash below.");
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public static int getAtmPIN() {
        return atmPIN;
    }

    public HashMap<String,Object> getPreviousTransactions() {
        return this.previousTransactions;
    }

    public void setPreviousTransactions(Boolean deposit) {
        DateFormat date_format_obj = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date d = new Date();

        if (deposit) {
            this.previousTransactions.put("Deposited: " + this.getDepositAmount(), date_format_obj.format(d));
        } else {
            this.previousTransactions.put("Withdrawn: " + this.getWithdrawAmount(), date_format_obj.format(d));
        }
    }
}