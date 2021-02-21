package main;

import java.util.Date;

/**
 * Represents a Business Account, extends the
 * abstract Account class. Contains methods to
 * start and stop meetings.
 *
 * @author Jake D
 * @author Patrick B
 * @author Artie G
 */
public class Business extends Account {
    private final Company company;
    public boolean inMeeting;
    public Date start;
    private Customer customer;

    /**
     * Constructor for a business account.
     *
     * @param fname The user's first name
     * @param lname The user's last name
     * @param email The user's email
     * @param password The user's password
     * @param company The user's company
     */
    public Business(String fname, String lname, String email, String password, Company company) {
        super(fname, lname, email, password);
        this.company = company;
    }

    public Company getCompany(){
        return company;
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
