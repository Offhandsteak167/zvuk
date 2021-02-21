package main;

import main.server.EchoServer;
import main.util.Email;
import main.data.AccountInformation;
import main.dummy.DummyDatabase;
import main.shared.Account;
import main.shared.Company;
import main.shared.Customer;
import main.shared.Meeting;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {

    public Account[] accounts = new Account[10];

    public static void main(String[] args)  {

        AccountInformation jakeDownie = new AccountInformation("Jake","Downie","jwd2488@rit.edu","JakeShot");
        //Email.send(jakeDownie.getEmail());
    }

    public static Company createTestCompany()  {
        Company test = new Company("Test");
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        return test;
    }
}
