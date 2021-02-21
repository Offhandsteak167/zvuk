package main.server;


public class ProcessWrapper {
    private final Process process;
    private final long time;
    public ProcessWrapper(Process process){
        this.process = process;
        this.time = System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }

    public void killProcess(){
        this.process.destroy();
    }
}
