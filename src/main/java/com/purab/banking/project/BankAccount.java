package com.purab.banking.project;
import java.util.ArrayList;

public class BankAccount {

    private int accountNumber;
    private String owner;
    private double balance;

    private ArrayList<Transaction> transactions;

    public BankAccount(
            int accountNumber,
            String owner) {

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;

        transactions =
                new ArrayList<>();
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;

        transactions.add(
                new Transaction(
                        "DEPOSIT",
                        amount
                )
        );

        return true;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0 ||
                amount > balance) {

            return false;
        }

        balance -= amount;

        transactions.add(
                new Transaction(
                        "WITHDRAW",
                        amount
                )
        );

        return true;
    }

    public boolean transfer(
            BankAccount receiver,
            double amount) {

        if (amount <= 0 ||
                amount > balance) {

            return false;
        }

        balance -= amount;

        receiver.balance += amount;

        transactions.add(
                new Transaction(
                        "TRANSFER TO "
                        + receiver.accountNumber,
                        amount
                )
        );

        receiver.transactions.add(
                new Transaction(
                        "TRANSFER FROM "
                        + accountNumber,
                        amount
                )
        );

        return true;
    }

    public void showBalance() {

        System.out.println(
                "Account: "
                        + accountNumber
        );

        System.out.println(
                "Owner: "
                        + owner
        );

        System.out.println(
                "Balance: £"
                        + balance
        );
    }

    public void showTransactions() {

        if (transactions.isEmpty()) {

            System.out.println(
                    "No transactions."
            );

            return;
        }

        System.out.println(
                "\nTransaction History:"
        );

        for (Transaction transaction
                : transactions) {

            System.out.println(
                    transaction
            );
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
}