package main.server;

public class CheckProcesses extends Thread{
    private CheckProcesses(){}
    private boolean isRunning;
    public void run(){
        isRunning = true;
        update();
    }
    public void update(){
        while(isRunning) {
            for (ProcessWrapper p : ServerSetup.processes) {
                // kill all processes that have been running for more than 15 min
                // very very very rough garbage collection
                if (System.currentTimeMillis() - p.getTime() > 15 * 60 * 1000) {
                    p.killProcess();
                }

            }
            try {
                sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.isRunning=false;
            }
        }
    }

    public void start() {

    }


}
