package main.util;

public class JS {
    public static void main(String[] args) {

        try {
            Process p = Runtime.getRuntime().exec("live-server --port=4444 --https=../../config/https-config.js");

        }catch(Exception ignored){}

    }
}
