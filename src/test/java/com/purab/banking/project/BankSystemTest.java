package com.purab.banking.project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankSystemTest {

    @Test
    void registrationShouldCreateUserAndAccount() {
        BankSystem bank = new BankSystem();

        assertTrue(bank.register("purab", "password123"));

        User user = bank.findUser("purab");

        assertNotNull(user);
        assertEquals("purab", user.getUsername());
        assertNotNull(user.getAccount());
        assertEquals(100001, user.getAccount().getAccountNumber());
    }

    @Test
    void duplicateUsernameShouldBeRejected() {
        BankSystem bank = new BankSystem();

        assertTrue(bank.register("purab", "password123"));
        assertFalse(bank.register("purab", "anotherPassword"));
    }

    @Test
    void correctCredentialsShouldLogin() {
        BankSystem bank = new BankSystem();

        bank.register("purab", "password123");

        User user = bank.login("purab", "password123");

        assertNotNull(user);
        assertEquals("purab", user.getUsername());
    }

    @Test
    void incorrectPasswordShouldFailLogin() {
        BankSystem bank = new BankSystem();

        bank.register("purab", "password123");

        User user = bank.login("purab", "wrongPassword");

        assertNull(user);
    }

    @Test
    void unknownUsernameShouldFailLogin() {
        BankSystem bank = new BankSystem();

        User user = bank.login("unknown", "password123");

        assertNull(user);
    }

    @Test
    void usersShouldReceiveDifferentAccountNumbers() {
        BankSystem bank = new BankSystem();

        bank.register("purab", "password123");
        bank.register("alex", "password456");

        User purab = bank.findUser("purab");
        User alex = bank.findUser("alex");

        assertEquals(100001, purab.getAccount().getAccountNumber());
        assertEquals(100002, alex.getAccount().getAccountNumber());
    }
}
