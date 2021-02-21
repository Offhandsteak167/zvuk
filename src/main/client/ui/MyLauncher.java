package main.client.ui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import main.shared.Customer;

public class MyLauncher {
    public static void signUp() {
        try {
            // Because we need to init the JavaFX toolkit - which usually Application.launch does
            // I'm not sure if this way of launching has any effect on anything
            new JFXPanel();

            Platform.runLater(() -> {
                // Your class that extends Application
                new SignUp().start(new Stage());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void signIn() {
        try {
            // Because we need to init the JavaFX toolkit - which usually Application.launch does
            // I'm not sure if this way of launching has any effect on anything
            new JFXPanel();

            Platform.runLater(() -> {
                // Your class that extends Application
                new CustomerLogin().start(new Stage());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void directory(Customer c) {
        try {
            // Because we need to init the JavaFX toolkit - which usually Application.launch does
            // I'm not sure if this way of launching has any effect on anything
            new JFXPanel();

            Platform.runLater(() -> {
                // Your class that extends Application
                new Directory().start(new Stage());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        signIn();
    }

}
