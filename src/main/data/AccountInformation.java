package main.data;

import main.Customer;

public class AccountInformation {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String address;
    private String payment;

    public AccountInformation(String fname, String lname, String email, String password){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public Customer createCustomerAccount(){
        return new Customer(fname,lname,email,password,address,payment);
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
