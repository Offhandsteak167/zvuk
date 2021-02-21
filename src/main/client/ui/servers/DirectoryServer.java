package main.client.ui.servers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.client.ui.MyLauncher;
import main.client.ui.util.Alert;
import main.server.dummy.DummyDatabase;
import main.shared.Customer;
import main.shared.Meeting;

public class DirectoryServer {
    public static void directoryButton(GridPane gridPane, TextField nameField, Button submitButton, Customer customer) {
        if (nameField.getText().isEmpty()) {
            Alert.sendAlert(gridPane, "Meeting queue created successfully!");
            return;
        }

        Meeting m = new Meeting(customer);
        DummyDatabase.companies.get(
                Integer.parseInt(nameField.getText())
        )
                .getMeetingQueue().addMeetingToQueue(m);
        MyLauncher.session.account.setMeeting(m);
        MyLauncher.session.account.currentMeeting.setMeetingCreator((Customer) MyLauncher.session.account);
        System.out.println(DummyDatabase.companies.get(2).toString());
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
        MyLauncher.launcher();
        Alert.sendAlert(gridPane, "Meeting queue created successfully!");
    }

}
