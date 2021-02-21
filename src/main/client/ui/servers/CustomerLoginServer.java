package main.client.ui.servers;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.client.ui.MyLauncher;
import main.client.ui.util.Alert;
import main.server.dummy.DummyDatabase;

public class CustomerLoginServer {
    public static void customerLoginSubmit(GridPane gridPane, TextField emailField, PasswordField passwordField, Button submitButton) {
        if (emailField.getText().isEmpty()) {
            Alert.sendAlert(gridPane, "Please enter your email id");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            Alert.sendAlert(gridPane, "Please enter a password");
            return;
        }
        for (int i = 0; i < DummyDatabase.accounts.size(); i++) {
            if(DummyDatabase.accounts.get(i).getEmail().equals(emailField.getText())){
                if(DummyDatabase.accounts.get(i).logIn(emailField.getText(), passwordField.getText())){
                    System.out.println("Login Successful");
                    MyLauncher.session.setAccount(DummyDatabase.accounts.get(i));
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    stage.close();
                    MyLauncher.launcher();
                    Alert.sendAlert(gridPane,"Login completed!");
                } else {
                    Alert.sendAlert(gridPane,"Login failed!");
                }
            }
        }
    }
}
