package main;

public class Test {
    public static void main(String[] args) {
        Customer c = new Customer("a","b","c","password", "a","a");
        boolean t = c.logIn("c","password");
        System.out.println(t);
    }
}
