package main.server;

import main.dummy.DummyDatabase;
import main.server.EchoServer;
import main.util.Event;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static main.dummy.DummyDatabase.logger;

public class ServerSetup {
    public static ArrayList<ProcessWrapper> processes;

    public static void main(String[] args) throws IOException {
        logger.addEvent(new Event("INFO","Logger is online."));

        DummyDatabase.getContents(new File("test.wtdb"));
        logger.addEvent(new Event("INFO","DummyDatabase is online."));

        processes = new ArrayList<>();
        logger.addEvent(new Event("INFO","processes is online."));

        EchoServer thread = new EchoServer();
        thread.start();
        logger.addEvent(new Event("INFO","EchoSever is online."));
    }
}
