package main.com.zvuk.java.shared;

import java.io.Serializable;
import java.util.Date;

public class Member extends Account implements Serializable {
    private Company company;
    private boolean inMeeting;
    private Date start;
    private Date end;
    public Member(String fname, String lname, String email, String password){
        super(fname, lname, email, password);
        Meeting meeting = null;
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

}
