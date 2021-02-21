package main.shared;

import main.util.NodeHandler;
import main.server.ProcessWrapper;
import main.server.ServerSetup;
import main.util.LinkHandler;

import java.util.Date;

public class Meeting {
    Customer meetingCreator;
    Business businessRep;
    final int waitTime;
    Process process;
    Interaction interaction;
    int port;
    public String link;

    public Meeting(Customer meetingCreator){
        this.meetingCreator = meetingCreator;
        waitTime = 0;
        process = null;
        interaction = null;
        businessRep = null;
        port = 0;
        link = null;
    }

    public void setBusinessRep(Business b){
        businessRep = b;
    }

    public void setMeetingCreator(Customer c){
        meetingCreator = c;
    }

    public void setProcess(Process process) {
        this.process = process;
        interaction = new Interaction(new Date(System.currentTimeMillis()), 0,meetingCreator, businessRep);
    }

    public void killProcess(){
        process.destroy();
        interaction.setE(new Date(System.currentTimeMillis()));
    }
    public void startProcess(){
        process = NodeHandler.start(this);
        ServerSetup.processes.add(new ProcessWrapper(process));
    }

    public void openMeetingLink(){
        LinkHandler.openWebpage(link);
    }

    @Override
    public String toString() {
        return "Meeting with "+meetingCreator.getEmail();
    }
}
