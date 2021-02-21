package main.shared;

import main.data.AccountInformation;
import main.server.Command;
import main.server.Packet;
import main.util.Connect;
import main.util.UserHandler;

import java.io.IOException;

public class HandleCommands {
    public static Command handleCommand(Packet packet) throws IOException, ClassNotFoundException {
        Command c = (Command) packet.decode();
        if (c.header.equals("get_queue")){
            UserHandler.testCommand();
        } else if (c.header.equals("test")){
            System.out.println(c.command);
            return new Command("state","true");
        } else if (c.header.equals("create")){
            if (c.command.equals("account")){
                AccountInformation o = (AccountInformation) c.object;
                Customer customer = o.createCustomerAccount();
                Connect.insert_new_account(Packet.toString(customer));
            }
        }
        return new Command("test","test");
    }
}
