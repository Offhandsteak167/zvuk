package main.com.zvuk.java.audio;

import main.com.zvuk.java.server.Database;
import main.com.zvuk.java.util.logger.Event;

public class AudioStreamInput {
    public static void main(String[] args) throws Exception {
        Microphone mic = new Microphone();
        try {
            mic.playSound("test.wav");
        } catch (Exception e){
            Database.logger.addEvent(new Event("WARN","File not found in AudioStreamInput"));
        }

    }
}
