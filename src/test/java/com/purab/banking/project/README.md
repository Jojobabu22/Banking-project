# JUnit 5 Tests for Secure Bank

These tests cover the main business logic in the current Secure Bank implementation.

## Tests included

### AES_Test
- Encryption returns ciphertext rather than the original plaintext.
- Encrypted text can be decrypted back to the original value.

### BankAccountTest
- Account starts with zero balance.
- Valid deposits.
- Invalid deposits.
- Valid withdrawals.
- Withdrawal exceeding balance.
- Successful transfers.
- Failed transfers due to insufficient funds.

### BankSystemTest
- User registration.
- Duplicate username rejection.
- Successful login.
- Incorrect password rejection.
- Unknown username rejection.
- Unique account-number generation.

## Maven setup

Place the production Java files in:

src/main/java/

Place the test files in:

src/test/java/

Then run:

mvn test

A successful run should report all tests as passing.

## Important note

These tests are written against the exact classes and default package structure supplied for the current project. If you add a Java package such as `com.securebank`, add the same package declaration to the production and test classes.
