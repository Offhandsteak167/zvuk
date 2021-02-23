package main.com.zvuk.java.util.data;

import main.com.zvuk.java.shared.Customer;

import java.io.Serializable;

public class AccountInformation implements Serializable {
    private int id;
    private final String fname;
    private final String lname;
    private final String email;
    private final String password;
    private String address;
    private String payment;

    public AccountInformation(String fname, String lname, String email, String password){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public Customer createCustomerAccount(){
        Customer newCustomer = new Customer(fname,lname,email,password,address,payment);
        //Email.send(newCustomer.getEmail()); <- possible issues depending on main.com.zvuk.java.server
        return newCustomer;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() { return this.email;}
}
