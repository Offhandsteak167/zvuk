package main.shared;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import main.util.cryptic;

/**
 * Abstractly represents an account,
 * contains encryption and decryption for handling passwords
 *
 * @author Jake D
 * @author Patrick B
 * @author Artie G
 */
public abstract class Account implements Serializable {
    private final String email;
    private final byte[] bytes;
    private byte[] password;

    /**
     * Constructor for an Account, encrypts passwords based
     * on an AES encryption algorithm. Stores encrypted password only.
     *
     * @param fname The user's first name
     * @param lname The user's last name
     * @param email The user's email
     * @param password The user's password
     */
    public Account(String fname, String lname, String email, String password) {
        this.email = email;
        this.bytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,
                0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };
        cryptic.encrypt(password, this.bytes);
        int id = email.hashCode();
    }

    /**
     * Method to log into an Account, decrypts the stored user's password
     * and compares to the stored Account password.
     *
     * @param email the login email
     * @param password the login password
     * @return true or false regarding whether the login was successful
     */
    public boolean logIn(String email, String password){
        String pswd = cryptic.decrypt(this.password, this.bytes);
        return this.email.equals(email) && pswd.equals(password);
    }

    /**
     * gets the user's email
     *
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }
}
