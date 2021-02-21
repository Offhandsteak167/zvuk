package main.data;

import main.shared.Customer;
import main.util.Email;

import java.io.Serializable;

public class AccountInformation implements Serializable {
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
        Customer newCustomer = new Customer(fname,lname,email,password,address,payment);
        //Email.send(newCustomer.getEmail()); <- possible issues depending on server
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
