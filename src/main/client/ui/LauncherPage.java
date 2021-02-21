package main.client.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LauncherPage extends Application {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Launcher Panel");
        primaryStage.setAlwaysOnTop(true);

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 200);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();

    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 5px on each side
        gridPane.setPadding(new Insets( 10, 10, 10, 10));



        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        gridPane.getColumnConstraints().addAll(columnOneConstraints);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel;
        if (MyLauncher.session.account != null) {
            headerLabel = new Label("Welcome " +MyLauncher.session.account.getEmail());
        } else {
            headerLabel =new Label("Welcome!");
        }
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        gridPane.add(headerLabel, 0,2,1,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        Button LoginCustomer = new Button("Meeting Queue");
        Button SignUp = new Button("Meeting Queue");
        Button LoginBusiness = new Button("Meeting Queue");
        Button CompanyDirectory = new Button("Meeting Queue");
        Button MeetingQueue = new Button("Meeting Queue");
        Button MeetingPage = new Button("Meeting Queue");


        if (MyLauncher.session.account != null) {
            if(MyLauncher.session.authenticated){
                 MeetingQueue = new Button("Meeting Queue");
                MeetingQueue.setPrefHeight(40);
                MeetingQueue.setDefaultButton(true);
                MeetingQueue.setPrefWidth(150);
                gridPane.add(MeetingQueue, 9, 4, 2, 1);
                GridPane.setHalignment(MeetingQueue, HPos.CENTER);
                GridPane.setMargin(MeetingQueue, new Insets(20, 0, 20, 0));
            } else {
                 CompanyDirectory = new Button("Company Directory");
                CompanyDirectory.setPrefHeight(40);
                CompanyDirectory.setDefaultButton(true);
                CompanyDirectory.setPrefWidth(150);
                gridPane.add(CompanyDirectory, 12, 4, 2, 1);
                GridPane.setHalignment(CompanyDirectory, HPos.CENTER);
                GridPane.setMargin(CompanyDirectory, new Insets(20, 0, 20, 0));
            }


             MeetingPage = new Button("Meeting Page");
            MeetingPage.setPrefHeight(40);
            MeetingPage.setDefaultButton(true);
            MeetingPage.setPrefWidth(150);
            gridPane.add(MeetingPage, 15, 4, 2, 1);
            GridPane.setHalignment(MeetingPage, HPos.CENTER);
            GridPane.setMargin(MeetingPage, new Insets(20, 0, 20, 0));
        } else {
            SignUp = new Button("Sign Up");
            SignUp.setPrefHeight(40);
            SignUp.setDefaultButton(true);
            SignUp.setPrefWidth(100);
            gridPane.add(SignUp, 0, 4, 2, 1);
            GridPane.setHalignment(SignUp, HPos.CENTER);
            GridPane.setMargin(SignUp, new Insets(20, 0,20,0));

             LoginCustomer = new Button("Login");
            LoginCustomer.setPrefHeight(40);
            LoginCustomer.setDefaultButton(true);
            LoginCustomer.setPrefWidth(150);
            gridPane.add(LoginCustomer, 3, 4, 2, 1);
            GridPane.setHalignment(LoginCustomer, HPos.CENTER);
            GridPane.setMargin(LoginCustomer, new Insets(20, 0,20,0));

        }
        SignUp.setOnAction(event -> {
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            stage.close();
            MyLauncher.signUp();

        });
        LoginCustomer.setOnAction(event -> {
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            stage.close();
            MyLauncher.signInC();
        });
        LoginBusiness.setOnAction(event -> {
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            stage.close();
            MyLauncher.signInB();
        });
        MeetingPage.setOnAction(event -> {
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            stage.close();
            MyLauncher.meeting();
        });
        CompanyDirectory.setOnAction(event -> {
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            stage.close();
            MyLauncher.directory();
        });
        MeetingQueue.setOnAction(event -> {
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            stage.close();
            MyLauncher.queue();
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

    public static void startUp() {
        launch();
    }
}