package main;


//Customer Account
//jakedownie8@gmail.com
//123


//Business Account
//artieg@gmail.com
//123


import main.data.AccountInformation;
import main.shared.Account;
import main.shared.Company;

public class Main {

    public Account[] accounts = new Account[10];

    public static void main(String[] args)  {

        AccountInformation jakeDownie = new AccountInformation("Jake","Downie","jwd2488@rit.edu","JakeShot");
        //Email.send(jakeDownie.getEmail());
    }

    public static Company createTestCompany()  {
        return new Company("Test");
    }
}
