package main;

import java.util.Arrays;

public class MeetingQueue{
    public NodeQueue<Meeting> queue;
    public Company company;
    public Account[] employees;

    public MeetingQueue(){
        queue = new NodeQueue<>();
    }

    public NodeQueue<Meeting> getQueue() {
        return queue;
    }

    public void addMeetingToQueue(Meeting meeting){
        queue.enqueue(meeting);
    }
    /**
    public void queueLifeCycle(){
        for (NodeQueue<Meeting> it = queue; it.hasNext(); ) {
            Meeting item = it.next();
            ++item.waitTime;
            if (item.waitTime > 500){
                MessageHandlers.sendMessage("This is taking too long!");
            }
        }
    }
     **/

    @Override
    public String toString() {
        return "main.MeetingQueue{" +
                "queue=" + queue.toString() +
                ", company=" + company +
                ", employees=" + Arrays.toString(employees) +
                '}';
    }
}
