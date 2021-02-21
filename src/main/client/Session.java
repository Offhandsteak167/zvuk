package main.client;

import main.shared.Account;
import main.shared.Business;
import main.shared.Company;
import main.shared.Customer;

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
