package main.com.zvuk.java.client.ui.servers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.com.zvuk.java.client.ui.MyLauncher;
import main.com.zvuk.java.client.ui.util.Alert;
import main.com.zvuk.java.server.Database;
import main.com.zvuk.java.shared.Member;
import main.com.zvuk.java.shared.Meeting;

public class DirectoryServer {
    public static void directoryButton(GridPane gridPane, TextField nameField, Button submitButton, Member member) {
        if (nameField.getText().isEmpty()) {
            Alert.sendAlert(gridPane, "Meeting queue created successfully!");
            return;
        }

        Meeting m = new Meeting(member);
        Database.companies.get(
                Integer.parseInt(nameField.getText())
        )
                .getMeetingQueue().addMeetingToQueue(m);
        MyLauncher.session.account.setMeeting(m);
        MyLauncher.session.account.currentMeeting.setMeetingCreator((Member) MyLauncher.session.account);
        System.out.println(Database.companies.get(2).toString());
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
        MyLauncher.launcher();
        Alert.sendAlert(gridPane, "Meeting queue created successfully!");
    }

}
