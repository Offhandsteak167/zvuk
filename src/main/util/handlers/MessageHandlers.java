package main.util.handlers;
import static javax.swing.JOptionPane.showMessageDialog;

public class MessageHandlers {
    public static void sendAlert(String message){
        showMessageDialog(null, message);
    }
}