package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("test");
    }

    public static Company createTestCompany() {
        Company test = new Company("Test");
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        test.getMeetingQueue().getQueue().enqueue(new Meeting(new Customer("Jake","D","d","d","d","d")));
        return test;
    }
}
