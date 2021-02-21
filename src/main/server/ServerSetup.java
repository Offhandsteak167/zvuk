package main.server;

import main.dummy.DummyDatabase;
import main.server.EchoServer;
import main.util.Event;
import main.util.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ServerSetup {
    public static Logger logger;
    public static ArrayList<ProcessWrapper> processes;

    public static void main(String[] args) throws IOException {
        processes = new ArrayList<>();
        logger = new Logger();
        logger.addEvent(new Event("INFO","Logger is online."));
        DummyDatabase.getContents(new File("test.wtdb"));
        logger.addEvent(new Event("INFO","DummyDatabase is online."));
        EchoServer thread = new EchoServer();
        thread.start();
        logger.addEvent(new Event("INFO","EchoSever is online."));
    }
}
