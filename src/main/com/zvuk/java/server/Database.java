package main.com.zvuk.java.server;

import main.com.zvuk.java.shared.Account;
import main.com.zvuk.java.shared.Company;
import main.com.zvuk.java.shared.Member;
import main.com.zvuk.java.shared.Role;
import main.com.zvuk.java.util.data.AccountInformation;
import main.com.zvuk.java.util.cryptic;
import main.com.zvuk.java.util.logger.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Database
{
    public static final Logger logger = new Logger();
    public static final Role defaultRole = new Role();

    public static final ArrayList<Company> companies = new ArrayList<>() {
        {
            add(new Company("0001"));
            add(new Company("Pa's Pizza Parlor"));
            add(new Company("Ritchie's Bricks"));
        }
    };

    public static final ArrayList<Account> accounts = new ArrayList<>() {
        {
            add(new Member("Jake", "Downie", "jakedownie8@gmail.com", "123"));


        }
    };

    public static Company get_company(int id){
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:zvuk.sqlite");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            Company c = new Company(id);
            ArrayList<Member> members = new ArrayList<>();

            ResultSet rs = statement.executeQuery("select * from companies");
            while(rs.next())
            {
                c.setName(rs.getString("name"));
                System.out.println("name = " + rs.getString("name"));
            }
            rs = statement.executeQuery("select * from members");
            while(rs.next())
            {
                if (rs.getInt("company_id") == (c.getId())){
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    c.addMember((new Member(fname,lname,email,password)));
                }
            }
            return c;
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
    public static void add_member(Member member){
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:zvuk.sqlite");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            String email = member.getEmail();
            Company company = member.getCompany();
            byte[] password = member.getPassword();
            statement.executeUpdate("insert into members values('" +email+"' '"+company.getId()+"' '"+ Arrays.toString(password) +"')");
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:zvuk.sqlite");
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
            System.err.println(e.getMessage());
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
                System.err.println(e.getMessage());
            }
        }
    }
}
