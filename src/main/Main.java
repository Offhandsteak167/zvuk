package main;

import main.data.AccountInformation;
import main.dummy.DummyDatabase;
import main.shared.Account;
import main.shared.Company;
import main.shared.Customer;
import main.shared.Meeting;

import java.io.File;
import java.io.IOException;

public class Main {

    public Account[] accounts = new Account[10];

    public static void main(String[] args) throws IOException {
        DummyDatabase.getContents(new File("test.wtdb"));
        AccountInformation jakeDownie = new AccountInformation("Jake","Downie","jwd2488@rit.edu","JakeShot");
       // Email.send(jakeDownie);
    }

    public static Company createTestCompany() {
        Company test = new Company("Test");
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        return test;
    }
}
