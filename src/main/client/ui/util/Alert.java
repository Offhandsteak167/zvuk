package main.client.ui.util;

import javafx.scene.layout.GridPane;
import javafx.stage.Window;

public class Alert {
    public static void sendAlert(GridPane gridPane, String message){
        showAlert(javafx.scene.control.Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Alert!", message);
    }
    private static void showAlert(javafx.scene.control.Alert.AlertType alertType, Window owner, String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
