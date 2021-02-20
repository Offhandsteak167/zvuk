package main;

public class Customer extends Account{
    private String address;
    private String payment;
    public Customer(String fname, String lname, String email, String password, String address, String payment){
        super(fname, lname, email, password);
        this.address = address;
        this.payment = payment;
    }


}
