package main.com.zvuk.java.client.ui.servers;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.com.zvuk.java.client.ui.MyLauncher;
import main.com.zvuk.java.client.ui.util.Alert;

public class MeetingServer {
    public static void leaveButton(GridPane gridPane, Button submitButton) {
        MyLauncher.session.account.currentMeeting.killProcess();
        MyLauncher.session.account.setMeeting(null);
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
        MyLauncher.launcher();
        Alert.sendAlert(gridPane, "Goodbye!");
    }
}
