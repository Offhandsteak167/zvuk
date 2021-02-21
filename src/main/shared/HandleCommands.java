package main.shared;

import main.data.AccountInformation;
import main.dummy.DummyDatabase;
import main.server.Command;
import main.server.Packet;
import main.util.Connect;
import main.util.MessageHandlers;

import java.io.IOException;
import java.util.ArrayList;

public class HandleCommands {
    public static Command handleCommand(Packet packet) throws IOException, ClassNotFoundException {
        Command c = (Command) packet.decode();
        switch (c.header) {
            case "get_queue":
                System.out.println("test");
                break;
            case "test":
                System.out.println(c.command);
                return new Command("state", "true");
            case "create":
                if (c.command.equals("account")) {
                    AccountInformation o = (AccountInformation) c.object;
                    Customer customer = o.createCustomerAccount();
                    try {
                        Connect.insert_new_account(Packet.toString(customer));
                    } catch (IOException e) {
                        MessageHandlers.sendAlert("User already exists!");
                    }
                }
                break;
            case "get_position":
                int position = 0;
                for (Company company : DummyDatabase.companies) {
                    ArrayList<Customer> z = company.getMeetingQueue().getMembers();
                    if (z.contains(c.object)) { // TODO: Check this out.
                        return new Command("display_position", String.valueOf(position));
                    }
                    position++;
                }
                return new Command("display_position", String.valueOf(position));
            case "display_position":
                MessageHandlers.sendAlert("You are currently in position " + c.command);
                return null;
        }
        return null;
    }
}
