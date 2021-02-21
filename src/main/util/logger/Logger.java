package main.util.logger;

import main.util.queue.NodeQueue;

public class Logger {

    final NodeQueue<Event> events;

    public Logger(){
        events = new NodeQueue<>();
    }

    public void addEvent(Event e){
        events.enqueue(e);
    }

    public void printEvent(){
        while(events.size() > 0){
            System.out.println(events.dequeue().toString());
        }
    }
}
