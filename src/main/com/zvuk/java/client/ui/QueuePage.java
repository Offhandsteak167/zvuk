package main.com.zvuk.java.client.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.com.zvuk.src.main.Main;
import main.com.zvuk.java.server.dummy.DummyDatabase;
import main.com.zvuk.java.shared.Meeting;
import main.com.zvuk.java.shared.MeetingQueue;

public class QueuePage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("List of Current Calls");
        primaryStage.setAlwaysOnTop(true);

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane, Main.createTestCompany().getMeetingQueue());
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

    private void addUIControls(GridPane gridPane, MeetingQueue thisQueue) {
        // Add Header
        Label headerLabel = new Label("Call Queue");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        int count = 0;
        for (int i = 0; i < thisQueue.getQueue().size(); i++) {
            String itemText = "";
            try {
                Meeting item = thisQueue.getQueue().getPlace(i).getValue();
                if (!item.toString().equals("")) {
                    itemText += item.toString() + "\n";
                    ++count;
                }
            } catch (IndexOutOfBoundsException ignored) {

            }
            gridPane.add(new Text(itemText), 1, count);
        }
        // Add Submit Button
        Button submitButton = new Button("Take Call");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(150);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(event -> {
            try {
                MyLauncher.session.account.currentMeeting = DummyDatabase.companies.get(0).getMeetingQueue().getQueue().dequeue();
            } catch (Exception e){
                System.out.println(DummyDatabase.companies.get(0).toString());
            }
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            stage.close();
            MyLauncher.launcher();
        });    }

    private void showAlert(Window owner) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registration Successful!");
        alert.setHeaderText(null);
        alert.setContentText("Welcome ");
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}