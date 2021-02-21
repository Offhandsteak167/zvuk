package main;
import main.util.*;
import main.shared.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Process p = NodeHandler.start();
        p.toString();
    }
    public static void testCustomer() throws GeneralSecurityException, IOException, MessagingException {
        Customer c = new Customer("a","b","c","password", "a","a");
        boolean t = c.logIn("c","password");
        System.out.println(t);
    }public static void testConnect(){
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            Connect.insertAccount(statement, 666, "Patrick", "Bryant", "DaisyIsFuckingAwesome@memes.org", "Thisissupersecure", "d", "d");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return;
        }

    }
}
