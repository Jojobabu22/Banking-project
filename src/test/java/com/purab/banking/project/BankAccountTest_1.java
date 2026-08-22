package com.purab.banking.project;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BankAccountTest_1 {

  @Test
    void newAccountShouldStartWithZeroBalance() {
        BankAccount account = new BankAccount(100001, "Purab");

        assertEquals(0.0, account.getBalance());
        assertEquals(100001, account.getAccountNumber());
        assertEquals("Purab", account.getOwner());
    }

    @Test
    void depositShouldIncreaseBalance() {
        BankAccount account = new BankAccount(100001, "Purab");

        assertTrue(account.deposit(500));

        assertEquals(500.0, account.getBalance());
    }

    @Test
    void negativeOrZeroDepositShouldBeRejected() {
        BankAccount account = new BankAccount(100001, "Purab");

        assertFalse(account.deposit(0));
        assertFalse(account.deposit(-50));

        assertEquals(0.0, account.getBalance());
    }

    @Test
    void withdrawalShouldDecreaseBalance() {
        BankAccount account = new BankAccount(100001, "Purab");
        account.deposit(500);

        assertTrue(account.withdraw(200));

        assertEquals(300.0, account.getBalance());
    }

    @Test
    void withdrawalGreaterThanBalanceShouldBeRejected() {
        BankAccount account = new BankAccount(100001, "Purab");
        account.deposit(500);

        assertFalse(account.withdraw(600));

        assertEquals(500.0, account.getBalance());
    }

    @Test
    void transferShouldUpdateBothAccounts() {
        BankAccount sender = new BankAccount(100001, "Purab");
        BankAccount receiver = new BankAccount(100002, "Alex");

        sender.deposit(1000);

        assertTrue(sender.transfer(receiver, 300));

        assertEquals(700.0, sender.getBalance());
        assertEquals(300.0, receiver.getBalance());
    }

    @Test
    void transferGreaterThanBalanceShouldFail() {
        BankAccount sender = new BankAccount(100001, "Purab");
        BankAccount receiver = new BankAccount(100002, "Alex");

        sender.deposit(100);

        assertFalse(sender.transfer(receiver, 200));

        assertEquals(100.0, sender.getBalance());
        assertEquals(0.0, receiver.getBalance());
    }
}
