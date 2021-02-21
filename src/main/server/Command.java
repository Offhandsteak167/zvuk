package main.server;

import java.io.Serializable;

public class Command implements Serializable {
    public final String header;
    public final String command;
    public final Object object;

    public Command(String header, String command, Object object){
        this.header = header;
        this.command = command;
        this.object = object;
    }
    public Command(String header, String command){
        this.header = header;
        this.command = command;
        this.object = null;
    }

}
