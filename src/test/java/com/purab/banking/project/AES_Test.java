package com.purab.banking.project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AES_Test {

    @Test
    void encryptAndDecryptShouldReturnOriginalText() {
        String original = "mySecretPassword123";

        String encrypted = AES.encrypt(original);
        String decrypted = AES.decrypt(encrypted);

        assertNotNull(encrypted);
        assertNotEquals(original, encrypted);
        assertEquals(original, decrypted);
    }

    @Test
    void encryptionShouldProduceDifferentCiphertextFromPlaintext() {
        String original = "hello";

        String encrypted = AES.encrypt(original);

        assertNotEquals(original, encrypted);
    }
}
