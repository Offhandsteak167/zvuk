package main.client.ui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import main.client.Session;

public class MyLauncher {
    public static Session session;

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
    public static void signInB() {
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
    public static void signInC() {
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

    public static void directory() {
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
    public static void queue() {
        try {
            // Because we need to init the JavaFX toolkit - which usually Application.launch does
            // I'm not sure if this way of launching has any effect on anything
            new JFXPanel();

            Platform.runLater(() -> {
                // Your class that extends Application
                new QueuePage().start(new Stage());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void meeting() {
        try {
            // Because we need to init the JavaFX toolkit - which usually Application.launch does
            // I'm not sure if this way of launching has any effect on anything
            new JFXPanel();

            Platform.runLater(() -> {
                // Your class that extends Application
                new Meeting().start(new Stage());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void launcher() {
        try {
            // Because we need to init the JavaFX toolkit - which usually Application.launch does
            // I'm not sure if this way of launching has any effect on anything
            new JFXPanel();

            Platform.runLater(() -> {
                // Your class that extends Application
                new LauncherPage().start(new Stage());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        session = new Session(null);
        launcher();


    }

}
