package main;
public class Business extends Account {
    private Company company;

    public Business(String fname, String lname, String email, String password, Company company) {
        super(fname, lname, email, password);
        this.company = company;
    }

    public void run() {
        try{
            wait()
        }catch(InterruptedException)
    }
}
