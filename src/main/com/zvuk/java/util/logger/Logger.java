package main.com.zvuk.java.util.logger;

import main.com.zvuk.java.util.queue.NodeQueue;

public class Logger {

    final NodeQueue<Event> events;

    public Logger(){
        events = new NodeQueue<>();
    }

    public void addEvent(Event e){
        System.out.println(e.toString());
        events.enqueue(e);
    }

    public void printEvent(){
        while(events.size() > 0){
            System.out.println(events.dequeue().toString());
        }
    }
}
