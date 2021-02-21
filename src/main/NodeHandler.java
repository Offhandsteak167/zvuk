package main;

import main.server.ServerSetup;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NodeHandler {
    public static Process start() {
        int port = 0;

        try {
            Runtime rt = Runtime.getRuntime();
            //String[] commands = {"wc", "config/https-config.js"};
            String commands = "main/helper.sh";
            Process proc = rt.exec(commands);
            return proc;
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

    } 

}