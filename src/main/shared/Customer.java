package main.shared;

public class Customer extends Account{
    private Meeting meeting;
    public Customer(String fname, String lname, String email, String password, String address, String payment){
        super(fname, lname, email, password);
        meeting = null;
    }


}
