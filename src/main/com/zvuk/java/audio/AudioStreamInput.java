package main.com.zvuk.java.audio;

import main.com.zvuk.java.server.dummy.DummyDatabase;
import main.com.zvuk.java.util.logger.Event;

public class AudioStreamInput {
    public static void main(String[] args) throws Exception {
        Microphone mic = new Microphone();
        try {
            mic.playSound("test.wav");
        } catch (Exception e){
            DummyDatabase.logger.addEvent(new Event("WARN","File not found in AudioStreamInput"));
        }

    }
}
