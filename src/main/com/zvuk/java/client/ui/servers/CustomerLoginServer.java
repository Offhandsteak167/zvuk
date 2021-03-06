package main.com.zvuk.java.client.ui.servers;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.com.zvuk.java.client.ui.MyLauncher;
import main.com.zvuk.java.client.ui.util.Alert;
import main.com.zvuk.java.server.Database;

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
        for (int i = 0; i < Database.accounts.size(); i++) {
            if(Database.accounts.get(i).getEmail().equals(emailField.getText())){
                if(Database.accounts.get(i).logIn(emailField.getText(), passwordField.getText())){
                    System.out.println("Login Successful");
                    MyLauncher.session.setAccount(Database.accounts.get(i));
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
