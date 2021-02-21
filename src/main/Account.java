package main;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
public abstract class Account{
    private int id;
    private String fname;
    private String lname;
    private String email;
    private byte[] bytes;
    private byte[] password;
    public Account(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.bytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,
                0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };
        SecretKeySpec key = new SecretKeySpec(this.bytes, "AES");
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        byte[] input = password.getBytes();
        cipher.update(input);
        try {
            byte[] cipherText = cipher.doFinal();
            this.password = cipherText;
        }catch(Exception e){
            return;
        }
        this.id = email.hashCode();
    }
    public boolean logIn(String email, String password){
        SecretKeySpec key = new SecretKeySpec(this.bytes, "AES");
        Cipher cipher;
        String pswd;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        byte[] input = this.password;
        cipher.update(input);
        try {
            byte[] decipheredText = cipher.doFinal();
            pswd = new String(decipheredText, StandardCharsets.UTF_8);
        }catch(Exception e){
            return false;
        }
        return this.email.equals(email) && pswd.equals(password);
    }

    public String getEmail() {
        return email;
    }
}
