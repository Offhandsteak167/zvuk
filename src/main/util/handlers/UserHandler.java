package main.util.handlers;

import main.shared.Customer;
import main.util.Connect;
import main.util.data.AccountInformation;
import java.io.*;
import java.util.Base64;

public class UserHandler {

    /** Read the object from Base64 string. */
    private static Object fromString( String s ) throws IOException ,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public void AddCustomerToDB(AccountInformation customer_info) throws IOException, ClassNotFoundException {
        Customer customer = customer_info.createCustomerAccount();
        var userDataString = toString(customer);
        Connect.insert_new_account(userDataString);
    }

}
