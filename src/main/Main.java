package main;

import main.data.AccountInformation;

public class Main {

    public Account[] accounts = new Account[10];

    public static void main(String[] args) {
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
