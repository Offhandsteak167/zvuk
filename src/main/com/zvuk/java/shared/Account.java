package main.com.zvuk.java.shared;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import main.com.zvuk.java.util.cryptic;

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
    public boolean elevated = false;
    private final byte[] password;
    public Meeting currentMeeting;

    //New Migration Code.
    private int user_id;
    private int user_role_id;
    private String user_name;
    private Date user_dob;

    /**
     * Constructor for an Account, encrypts passwords based
     * on an AES encryption algorithm. Stores encrypted password only.
     *
     * @param fname The user's first name
     * @param lname The user's last name
     * @param email The user's email
     * @param password The user's password
     */
    public Account(String fname, String lname, String email, String password)  {
        this.email = email;
        this.currentMeeting = null;
        this.bytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09,
                0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };
        this.password = cryptic.encrypt(password, this.bytes);

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
        System.out.println(email);
        System.out.println(Arrays.toString(this.password));
        String pswd = cryptic.decrypt(this.password, this.bytes);
        return this.email.equals(email) && pswd.equals(password);
    }

    public void setMeeting(Meeting meeting) {
        this.currentMeeting = meeting;
    }

    public void sendMessageReply(Chat chat, String message){
        Chat newChat = new Chat(message,this);
        chat.addReply(newChat);
    }
    public void sendNewMessage(Channel channel, String message){
        Chat newChat = new Chat(message,this);
        channel.addMessage(newChat);
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
