package com.purab.banking.project;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        BankSystem bank =
                new BankSystem();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println(
                    "========================"
            );

            System.out.println(
                    "       SECURE BANK"
            );

            System.out.println(
                    "========================"
            );

            System.out.println(
                    "1. Register"
            );

            System.out.println(
                    "2. Login"
            );

            System.out.println(
                    "3. Exit"
            );

            System.out.print(
                    "Choose: "
            );

            int choice =
                    scanner.nextInt();

            scanner.nextLine();

            if (choice == 1) {

                register(scanner, bank);

            } else if (choice == 2) {

                login(scanner, bank);

            } else if (choice == 3) {

                running = false;

                System.out.println(
                        "Goodbye!"
                );

            } else {

                System.out.println(
                        "Invalid option."
                );
            }
        }

        scanner.close();
    }

    private static void register(
            Scanner scanner,
            BankSystem bank) {

        System.out.print(
                "Username: "
        );

        String username =
                scanner.nextLine();

        System.out.print(
                "Password: "
        );

        String password =
                scanner.nextLine();

        boolean success =
                bank.register(
                        username,
                        password
                );

        if (success) {

            User user =
                    bank.findUser(username);

            System.out.println(
                    "Registration successful!"
            );

            System.out.println(
                    "Your account number: "
                    + user.getAccount()
                            .getAccountNumber()
            );

        } else {

            System.out.println(
                    "Username already exists."
            );
        }
    }

    private static void login(
            Scanner scanner,
            BankSystem bank) {

        System.out.print(
                "Username: "
        );

        String username =
                scanner.nextLine();

        System.out.print(
                "Password: "
        );

        String password =
                scanner.nextLine();

        User user =
                bank.login(
                        username,
                        password
                );

        if (user == null) {

            System.out.println(
                    "Invalid login."
            );

            return;
        }

        System.out.println(
                "Login successful!"
        );

        bankingMenu(
                scanner,
                bank,
                user
        );
    }

    private static void bankingMenu(
            Scanner scanner,
            BankSystem bank,
            User user) {

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println();
            System.out.println(
                    "========================"
            );

            System.out.println(
                    "      BANK ACCOUNT"
            );

            System.out.println(
                    "========================"
            );

            System.out.println(
                    "1. Check Balance"
            );

            System.out.println(
                    "2. Deposit"
            );

            System.out.println(
                    "3. Withdraw"
            );

            System.out.println(
                    "4. Transfer"
            );

            System.out.println(
                    "5. Transaction History"
            );

            System.out.println(
                    "6. Logout"
            );

            System.out.print(
                    "Choose: "
            );

            int choice =
                    scanner.nextInt();

            scanner.nextLine();

            BankAccount account =
                    user.getAccount();

            switch (choice) {

                case 1:

                    account.showBalance();

                    break;

                case 2:

                    System.out.print(
                            "Amount: £"
                    );

                    double deposit =
                            scanner.nextDouble();

                    if (account.deposit(
                            deposit)) {

                        System.out.println(
                                "Deposit successful."
                        );

                    } else {

                        System.out.println(
                                "Invalid amount."
                        );
                    }

                    break;

                case 3:

                    System.out.print(
                            "Amount: £"
                    );

                    double withdrawal =
                            scanner.nextDouble();

                    if (account.withdraw(
                            withdrawal)) {

                        System.out.println(
                                "Withdrawal successful."
                        );

                    } else {

                        System.out.println(
                                "Invalid amount or insufficient funds."
                        );
                    }

                    break;

                case 4:

                    System.out.print(
                            "Receiver username: "
                    );

                    String receiverName =
                            scanner.nextLine();

                    User receiver =
                            bank.findUser(
                                    receiverName
                            );

                    if (receiver == null) {

                        System.out.println(
                                "User not found."
                        );

                        break;
                    }

                    System.out.print(
                            "Amount: £"
                    );

                    double amount =
                            scanner.nextDouble();

                    if (account.transfer(
                            receiver.getAccount(),
                            amount)) {

                        System.out.println(
                                "Transfer successful."
                        );

                    } else {

                        System.out.println(
                                "Transfer failed."
                        );
                    }

                    break;

                case 5:

                    account.showTransactions();

                    break;

                case 6:

                    loggedIn = false;

                    System.out.println(
                            "Logged out."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid option."
                    );
            }
        }
    }
}