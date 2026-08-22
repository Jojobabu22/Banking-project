package com.purab.banking.project;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES {

    static SecretKey key;

    static {
        try {
            KeyGenerator generator =
                    KeyGenerator.getInstance("AES");

            generator.init(256);

            key = generator.generateKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String text) {

        try {
            Cipher cipher =
                    Cipher.getInstance("AES");

            cipher.init(
                    Cipher.ENCRYPT_MODE,
                    key
            );

            byte[] encrypted =
                    cipher.doFinal(
                            text.getBytes()
                    );

            return Base64.getEncoder()
                    .encodeToString(encrypted);

        } catch (Exception e) {
            return null;
        }
    }

    public static String decrypt(String text) {

        try {
            Cipher cipher =
                    Cipher.getInstance("AES");

            cipher.init(
                    Cipher.DECRYPT_MODE,
                    key
            );

            byte[] encrypted =
                    Base64.getDecoder()
                            .decode(text);

            byte[] decrypted =
                    cipher.doFinal(encrypted);

            return new String(decrypted);

        } catch (Exception e) {
            return null;
        }
    }
}