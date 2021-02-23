package main.com.zvuk.java.client;

import main.com.zvuk.java.shared.Account;
import main.com.zvuk.java.shared.Company;

public class Session {
    public Account account;
    public Company company;
    public boolean authenticated;
    public Session(Account account){
        this.account = account;
        this.authenticated = false;
    }

    public void setAccount(Account account) {
        this.account = account;
        if (account.elevated){
            authenticated = true;
        }
    }
}
