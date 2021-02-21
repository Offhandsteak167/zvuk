package main;

public class Meeting {
    Customer meetingCreator;
    int waitTime;

    public Meeting(Customer meetingCreator){
        this.meetingCreator = meetingCreator;
        waitTime = 0;
    }

    @Override
    public String toString() {
        return "Meeting with "+meetingCreator.getEmail();
    }
}
