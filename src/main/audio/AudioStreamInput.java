package main.audio;

import main.server.ServerSetup;
import main.server.dummy.DummyDatabase;
import main.util.logger.Event;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

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
