package main;
public class Business extends Account {
    private Company company;
    private boolean inMeeting;
    private Date start;
    public Business(String fname, String lname, String email, String password, Company company) {
        super(fname, lname, email, password);
        this.company = company;
    }


}
