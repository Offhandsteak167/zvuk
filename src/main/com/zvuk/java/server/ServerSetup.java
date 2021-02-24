package main.com.zvuk.java.server;

import main.com.zvuk.java.server.dummy.DummyDatabase;
import main.com.zvuk.java.util.logger.Event;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static main.com.zvuk.java.server.dummy.DummyDatabase.logger;

public class ServerSetup {
    public static ArrayList<ProcessWrapper> processes;

    public static void start() throws IOException {
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
