package main.shared;

import main.NodeHandler;
import main.server.ServerSetup;

import java.util.Date;

public class Meeting {
    final Customer meetingCreator;
    Business businessRep;
    final int waitTime;
    Process process;
    Interaction interaction;

    public Meeting(Customer meetingCreator){
        this.meetingCreator = meetingCreator;
        waitTime = 0;
        process = null;
        interaction = null;
        businessRep = null;
    }

    public void setBusinessRep(Business b){
        businessRep = b;
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
        process = NodeHandler.start();
        ServerSetup.processes.add(process);
    }

    @Override
    public String toString() {
        return "Meeting with "+meetingCreator.getEmail();
    }
}
