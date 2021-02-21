package main.util;

import main.dummy.DummyDatabase;
import main.server.EchoServer;

import java.io.File;
import java.io.IOException;

public class ServerSetup {
    public static Logger logger;

    public static void main(String[] args) throws IOException {
        logger = new Logger();
        logger.addEvent(new Event("INFO","Logger is online."));
        DummyDatabase.getContents(new File("test.wtdb"));
        logger.addEvent(new Event("INFO","DummyDatabase is online."));
        EchoServer thread = new EchoServer();
        thread.start();
        logger.addEvent(new Event("INFO","EchoSever is online."));
    }
}
