package main.com.zvuk.java.util;

import main.com.zvuk.java.server.Database;
import main.com.zvuk.java.server.Packet;
import main.com.zvuk.java.shared.Account;
import main.com.zvuk.java.util.logger.Event;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

import static main.com.zvuk.java.server.Database.logger;

/**
 *
 * @author sqlitetutorial.net
 */
public class Connect {

    public static boolean does_account_exist(String input) throws IOException, ClassNotFoundException {
        return Database.accounts.contains(Packet.fromString(input));
        //return DummyDatabase.containsObject(new File("test.wtdb"),input);
    }

    public static void  insert_new_account(String input) throws IOException, ClassNotFoundException {
        Database.accounts.add((Account) Packet.fromString(input));
        /**
        DummyDatabase.addObject(new File("test.wtdb"), input);
        if (!does_account_exist(input)) {
            DummyDatabase.accounts.add((Account) Packet.fromString(input));
            DummyDatabase.addObject(new File("test.wtdb"), input);
        } else {
            throw new IOException("Account already exists!");
        }
         **/

        //TODO: CHECK IF USER ALREADY EXISTS AND RETURN STATE
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("insert into accounts '"+input+"'");
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            logger.addEvent(new Event("ERROR",e.getMessage()));
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                logger.addEvent(new Event("ERROR",e.getMessage()));
            }
        }
    }

    /**
     * Connect to a sample database
     */
    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from person");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            logger.addEvent(new Event("ERROR",e.getMessage()));
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                logger.addEvent(new Event("ERROR",e.getMessage()));
            }
        }
    }

    public static void insertAccount(Statement statement, int ID, String fname, String lname, String email, String password, String address, String payment){
        try {
            String temp = "insert into Accounts values(" + ID + ", '" + fname + "', '"+ lname + "', '" + email + "', '" + password + "')";
            System.out.println(temp);
            statement.executeUpdate(temp);
        } catch (SQLException throwables) {
            logger.addEvent(new Event("ERROR", Arrays.toString(throwables.getStackTrace())));


        }
    }
}