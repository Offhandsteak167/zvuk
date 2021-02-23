package main.com.zvuk.java.util.handlers;

public class MeetingHandler extends Thread {
    private final String link;

    public MeetingHandler(String link) {
        this.link = link;
    }

    public void run(){
        openMeetingLink();
    }

    public void openMeetingLink(){
        LinkHandler.openWebpage(link);
    }
}
