package com.purab.banking.project;
import java.util.ArrayList;

public class BankSystem {

    private ArrayList<User> users;
    private int nextAccountNumber;

    public BankSystem() {
        users = new ArrayList<>();
        nextAccountNumber = 100001;
    }

    public boolean register(String username, String password) {
        // Check username
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        // Encrypt password
        String encryptedPassword = AES.encrypt(password);

        // Create account
        BankAccount account = new BankAccount(nextAccountNumber, username);
        nextAccountNumber++;

        // Create user
        User user = new User(username, encryptedPassword, account);
        users.add(user);

        return true;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                String decryptedPassword = AES.decrypt(user.getPassword());

                if (decryptedPassword.equals(password)) {
                    return user;
                }
            }
        }

        return null;
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }
}
