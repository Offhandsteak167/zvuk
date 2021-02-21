package main.shared;

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
        elevated = true;
        this.company = company;
    }

    public Company getCompany(){
        return company;
    }

    public boolean isInMeeting(){
        return this.inMeeting;
    }

    /**
     * Starts a meeting and associates the business account with that meeting
     *
     * @param m the meeting to start
     */
    public void startMeeting(Meeting m){
        this.start = new Date(System.currentTimeMillis());
        this.inMeeting = true;
        currentMeeting = m;
        m.businessRep = this;
        m.startProcess();

    }

    /**
     * Ends a meeting, making the business account available again
     *
     * @param rating the "rating" of the meeting
     * @return the Interaction to store.
     */
    public Interaction endMeeting(int rating){
        Interaction i = new Interaction(this.start,  rating,this.customer, this);
        this.inMeeting = false;
        currentMeeting.killProcess();
        currentMeeting = null;
        return i;
    }

}
