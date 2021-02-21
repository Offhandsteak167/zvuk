package main.util;

import main.Customer;
import main.data.AccountInformation;

public class UserHandler {
    public void AddCustomerToDB(AccountInformation customer){
        customer.createCustomerAccount();
    }

}
