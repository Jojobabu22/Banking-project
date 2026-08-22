Banking System

A secure Java-based banking management system developed to demonstrate object-oriented programming, financial transaction processing, encryption, and automated testing.

Overview

This project is a console-based banking application that allows users to manage bank accounts and perform common banking operations.

The system was developed using Java and Maven, with a focus on clean object-oriented design, transaction management, security, and software testing.

Features
Create and manage bank accounts
Deposit money
Withdraw money
Transfer money between accounts
Check account balances
Record financial transactions
User management
AES encryption for sensitive information
Input validation
Exception handling
Automated unit testing with JUnit 5
Technologies Used
Technology	Purpose
Java	Main programming language
Maven	Project and dependency management
JUnit 5	Unit testing
AES	Data encryption
Git	Version control
GitHub	Source-code repository
NetBeans / VS Code	Development environment
System Design

The application follows an object-oriented design where different classes are responsible for different parts of the banking system.

Main Components

BankSystem

Responsible for managing the overall banking operations and accounts.

BankAccount

Represents an individual bank account and manages:

Account details
Balance
Deposits
Withdrawals
Transactions

User

Represents a customer using the banking system.

Transaction

Represents a financial transaction such as:

Deposit
Withdrawal
Transfer

AES

Provides encryption functionality for protecting sensitive information.

Main

Provides the entry point for running the application.

Security

Security is an important part of this project.

The application includes AES (Advanced Encryption Standard) encryption to demonstrate how sensitive information can be protected.

The encryption functionality uses Java's cryptography libraries, including:

javax.crypto.Cipher
javax.crypto.KeyGenerator
javax.crypto.SecretKey

Note: This project is an educational banking simulation and is not intended for production financial use.

Testing

The project uses JUnit 5 for automated testing.

Example tests include:

Checking that a new account starts with a zero balance
Testing deposits
Testing withdrawals
Testing invalid transactions
Checking account behaviour

Tests can be executed using Maven:

mvn test
How to Run
Prerequisites

You will need:

Java JDK 17 or later
Maven
Git
A Java IDE such as VS Code, IntelliJ IDEA, or NetBeans
Clone the Repository
git clone https://github.com/Jojobabu22/Banking-project.git
Navigate to the Project
cd Banking-project
Build the Project
mvn clean package
Run Tests
mvn test
Run the Application

Run the Main.java class from your IDE.

Example Banking Operations

A typical user can perform operations such as:

1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. View Balance
6. View Transactions
7. Exit
Future Improvements

The current system is a foundation for a larger banking application. Possible future improvements include:

Spring Boot REST API
PostgreSQL/MySQL database
Authentication and authorisation
Password hashing
JWT-based authentication
Role-based access control
Transaction persistence
RESTful endpoints
Logging and monitoring
Docker containerisation
Integration testing
Improved encryption key management
Web-based user interface
Learning Objectives

This project demonstrates practical understanding of:

Object-oriented programming
Java classes and objects
Encapsulation
Methods and parameters
Collections
Exception handling
File/project structure
Maven
JUnit testing
Cryptography
Git and GitHub
Basic software architecture
Author

Purab Shakya

BSc (Hons) Computing Systems
Ulster University, London

Disclaimer

This application is developed for educational purposes. It is a demonstration of software engineering and banking-system concepts and should not be used to process real financial transactions or sensitive customer information.
