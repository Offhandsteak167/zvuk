package main.com.zvuk.java.util;

public class JS {
    public static void main(String[] args) {

        try {
            Process p = Runtime.getRuntime().exec("live-main.com.zvuk.java.server --port=4444 --https=../../config/https-config.js");

        }catch(Exception ignored){}

    }
}
