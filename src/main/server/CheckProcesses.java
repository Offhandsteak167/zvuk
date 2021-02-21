package main.server;

public class CheckProcesses extends Thread{
    private CheckProcesses(){}
    private Thread t;

    public void run(){
        update();
    }
    public void update(){
        for (ProcessWrapper p:ServerSetup.processes) {
            // kill all processes that have been running for more than 15 min
            // very very very rough garbage collection
            if(System.currentTimeMillis() - p.getTime() > 15 * 60 * 1000){
                p.killProcess();
            }
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this,"CheckProcesses");
        }
    }


}
