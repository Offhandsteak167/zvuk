package main.util;

import java.util.Calendar;
import java.util.Date;

public class Event {
    private String level;
    private String content;
    private Date time;

    public Event(String level, String content){
        Calendar c1 = Calendar.getInstance();
        time = c1.getTime();
        this.level = level;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Event{" +
                "level='" + level + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
