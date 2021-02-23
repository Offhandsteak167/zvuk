package main.com.zvuk.java.util;

import main.com.zvuk.java.shared.Meeting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NodeHandler {
    public static Process start(Meeting m) {
        String link;
        try {
            Runtime rt = Runtime.getRuntime();
            //String[] commands = {"wc", "config/https-config.js"};
            String commands = "main/com/zvuk/java/util/helper.sh";
            Process proc = rt.exec(commands);
            m.running = true;
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