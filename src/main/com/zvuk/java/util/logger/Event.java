package main.com.zvuk.java.util.logger;

import java.util.Calendar;
import java.util.Date;

public class Event {
    private final String level;
    private final String content;
    private final Date time;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Event(String level, String content){
        Calendar c1 = Calendar.getInstance();
        time = c1.getTime();
        this.level = level;
        this.content = content;
    }

    @Override
    public String toString() {
        switch (level){
            case ("ERROR"):
                return ANSI_RED+level+ANSI_RESET + ": " + content + " " + time;
            case ("WARN"):
                return ANSI_YELLOW+level+ANSI_RESET + ": " + content + " " + time;
            case ("INFO"):
                return ANSI_GREEN+level+ANSI_RESET + ": " + content + " " + time;
        }
        return "SOMETHING WENT WRONG";
    }
}
