package main.com.zvuk.java.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * Cryptic is used to encrypt and decrypt passwords so passwords are not stored as pain text
 *
 * @author Jake D
 * @author Patrick B
 * @author Artie G
 */
public class cryptic {

    /**
     * encrypts a string with the provided byte key
     *
     * @param s the input string
     * @param b the input byte key
     * @return the encrypted string
     */
    public static byte[] encrypt(String s, byte[] b) {
        SecretKeySpec key = new SecretKeySpec(b, "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new byte[0];
        }
        byte[] input = s.getBytes();
        cipher.update(input);
        try {
            return cipher.doFinal();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    /**
     * Decrypts the provided byte array
     *
     * @param p the input byte array to decrypt
     * @param b the key to use
     * @return the decrypted String
     */
    public static String decrypt(byte[] p, byte[] b) {
        SecretKeySpec key = new SecretKeySpec(b, "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
        cipher.update(p);
        try {
            byte[] decipheredText = cipher.doFinal();
            return new String(decipheredText, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }
}
