package main;

import main.server.ServerSetup;
import main.shared.Meeting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class NodeHandler {
    public static Process start(Meeting m) {
        String link = "";
        try {
            Runtime rt = Runtime.getRuntime();
            //String[] commands = {"wc", "config/https-config.js"};
            String commands = "main/helper.sh";
            Process proc = rt.exec(commands);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.split(" ").length == 4){
                    link = (line.split(" ")[3]);
                    m.link = link;
                }
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