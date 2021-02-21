package main.server;


public class ProcessWrapper {
    private Process process;
    private long time;
    public ProcessWrapper(Process process){
        this.process = process;
        this.time = System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }
}
