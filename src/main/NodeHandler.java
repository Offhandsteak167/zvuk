package main;

import main.server.ServerSetup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class NodeHandler {
    public static Process start() {
        int port = 0;

        try {
            Runtime rt = Runtime.getRuntime();
            //String[] commands = {"wc", "config/https-config.js"};
            String commands = "main/helper.sh";
            Process proc = rt.exec(commands);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            proc.waitFor();
            System.out.println("ok!");
            return proc;
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

}