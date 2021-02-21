package main.client.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.NodeHandler;
import main.dummy.DummyDatabase;
import main.shared.Customer;

public class Meeting extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Waiting Room");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Waiting Room");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        Label nameLabel;
        // Add Name Label
        if ( MyLauncher.session.account != null){
            nameLabel= new Label(MyLauncher.session.account.currentMeeting.toString());
        } else {
            nameLabel = new Label("Unused Room");
        }
        gridPane.add(nameLabel, 0,1);

        // Add Submit Button
        Button submitButton = new Button("Join");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        // Add Submit Button
        Button leaveButton = new Button("End Meeting");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(leaveButton, 0, 6, 2, 1);
        GridPane.setHalignment(leaveButton, HPos.CENTER);
        GridPane.setMargin(leaveButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(event -> {
            if (MyLauncher.session.account.currentMeeting != null) {
                NodeHandler.start(MyLauncher.session.account.currentMeeting);
                MyLauncher.session.account.currentMeeting.openMeetingLink();
            } else {
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "No meeting!","Sorry!");
            }

        });
        leaveButton.setOnAction(event -> {
            MyLauncher.session.account.currentMeeting.killProcess();
            MyLauncher.session.account.setMeeting(null);
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();
            MyLauncher.launcher();
            showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Meeting left!","Goodbye!");
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}