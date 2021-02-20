public abstract class Account extends Thread {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    public Account(String fname, String lname, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.id = email.hashCode();
    }
}
