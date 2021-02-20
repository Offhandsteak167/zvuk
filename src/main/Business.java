package main;

import java.util.Date;

public class Business extends Account {
    private Company company;
    private boolean inMeeting;
    private Date start;
    private Customer customer;
    public Business(String fname, String lname, String email, String password, Company company) {
        super(fname, lname, email, password);
        this.company = company;
    }
    public boolean isInMeeting(){
        return this.inMeeting;
    }

    public void startMeeting(Customer c){
        this.customer = c;
        this.start = new Date(System.currentTimeMillis());
        this.inMeeting = true;
    }

    public Interaction endMeeting(int rating){
        Interaction i = new Interaction(this.start, new Date(System.currentTimeMillis()), rating,this.customer, this);
        this.inMeeting = false;
        return i;
    }

}
