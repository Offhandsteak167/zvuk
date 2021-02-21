package main.server;

public class CheckProcesses extends Thread{
    public CheckProcesses(){}
    public void run(){
        update();
    }
    public void update(){
        for (ProcessWrapper p:ServerSetup.processes) {
            if(System.currentTimeMillis() - p.getTime() > 10 * 60 * 1000){

            }
        }
    }
}
