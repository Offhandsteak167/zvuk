package main.shared;

import main.util.data.AccountInformation;
import main.server.dummy.DummyDatabase;
import main.server.Command;
import main.server.Packet;
import main.util.Connect;
import main.util.handlers.MessageHandlers;

import java.io.IOException;
import java.util.ArrayList;

public class HandleCommands {
    public static Command handleCommand(Packet packet) throws IOException, ClassNotFoundException {
        Command c = (Command) packet.decode();
        switch (c.header) {
            case "get_queue":
                getQueue();
            case "test":
                return test(c);
            case "create":
                create(c);
            case "get_position":
                return getPosition(c);
            case "display_position":
                return displayPosition(c);
        }
        return null;
    }

    private static Command displayPosition(Command c) {
        MessageHandlers.sendAlert("You are currently in position " + c.command);
        return null;
    }

    private static Command getPosition(Command c) {
        int position = 0;
        for (Company company : DummyDatabase.companies) {
            ArrayList<Customer> z = company.getMeetingQueue().getMembers();
            if (z.contains(c.object)) { // TODO: Check this out.
                return new Command("display_position", String.valueOf(position));
            }
            position++;
        }
        return new Command("display_position", String.valueOf(position));
    }

    private static void create(Command c) throws ClassNotFoundException {
        if (c.command.equals("account")) {
            createAccount(c);
        }
    }

    private static void createAccount(Command c) throws ClassNotFoundException {
        AccountInformation o = (AccountInformation) c.object;
        Customer customer = o.createCustomerAccount();
        try {
            Connect.insert_new_account(Packet.toString(customer));
        } catch (IOException e) {
            MessageHandlers.sendAlert("User already exists!");
        }
    }

    private static Command test(Command c) {
        System.out.println(c.command);
        return new Command("state", "true");
    }

    private static void getQueue() {
        System.out.println("test");
    }
}
