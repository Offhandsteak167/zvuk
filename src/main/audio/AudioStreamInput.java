package main.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import java.io.ByteArrayOutputStream;

public class AudioStreamInput {
    public static void main(String[] args) throws Exception {
        Microphone mic = new Microphone();
        mic.playSound("test.wav");

    }
}
