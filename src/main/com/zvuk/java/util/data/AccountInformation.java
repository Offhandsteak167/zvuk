package main.com.zvuk.java.util.data;

import main.com.zvuk.java.shared.Member;

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

    public Member createCustomerAccount(){
        Member newMember = new Member(fname,lname,email,password,address,payment);
        //Email.send(newCustomer.getEmail()); <- possible issues depending on main.com.zvuk.java.server
        return newMember;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() { return this.email;}
}
