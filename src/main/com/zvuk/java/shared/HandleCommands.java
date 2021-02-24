package main.com.zvuk.java.shared;

import main.com.zvuk.java.util.data.AccountInformation;
import main.com.zvuk.java.server.Database;
import main.com.zvuk.java.server.Command;
import main.com.zvuk.java.server.Packet;
import main.com.zvuk.java.util.Connect;
import main.com.zvuk.java.util.handlers.MessageHandlers;

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
        for (Company company : Database.companies) {
            ArrayList<Member> z = company.getMeetingQueue().getMembers();
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
        Member member = o.createCustomerAccount();
        try {
            Connect.insert_new_account(Packet.toString(member));
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
