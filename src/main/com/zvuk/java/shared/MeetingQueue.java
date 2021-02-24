package main.com.zvuk.java.shared;

import main.com.zvuk.java.util.queue.NodeQueue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MeetingQueue implements Serializable {
    public final NodeQueue<Meeting> queue;
    public Company company;
    public Account[] employees;

    public MeetingQueue(){
        queue = new NodeQueue<>();
    }

    public NodeQueue<Meeting> getQueue() {
        return queue;
    }

    public ArrayList<Member> getMembers() {
        ArrayList<Member> toReturn = new ArrayList<>();
        for (int i = 0; i < queue.size(); i++) {
            toReturn.add(queue.getPlace(i).getValue().meetingCreator);
        }
        return toReturn;
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
        return "main.com.zvuk.java.shared.MeetingQueue{" +
                "queue=" + queue.toString() +
                ", company=" + company +
                ", employees=" + Arrays.toString(employees) +
                '}';
    }
}
