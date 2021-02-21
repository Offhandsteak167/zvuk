package main.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class cryptic {
    public static byte[] encrypt(String s, byte[] b){
        SecretKeySpec key = new SecretKeySpec(b, "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new byte[0];
        }
        byte[] input = s.getBytes();
        cipher.update(input);
        try {
            return cipher.doFinal();
        }catch(Exception e){
            return new byte[0];
        }
    }
    public static String decrypt(byte[] p, byte[] b){
        SecretKeySpec key = new SecretKeySpec(b, "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
        byte[] input = p;
        cipher.update(input);
        try {
            byte[] decipheredText = cipher.doFinal();
            return new String(decipheredText, StandardCharsets.UTF_8);
        }catch(Exception e){
            return "";
        }
    }
}
