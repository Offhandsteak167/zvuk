package main;

public class Meeting {
    Account meetingCreator;
    int waitTime;

    public Meeting(Account meetingCreator){
        this.meetingCreator = meetingCreator;
        waitTime = 0;
    }

    @Override
    public String toString() {
        return "main.Meeting{" +
                "meetingCreator=" + meetingCreator +
                ", priority=" + waitTime +
                '}';
    }
}
