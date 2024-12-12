package org.bham;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            System.out.println("Starting application...");
            AuthenticationController auth = new AuthenticationController();
            Scene scene = auth.getScene();

            if (scene == null) {
                throw new RuntimeException("Scene is null");
            }

            primaryStage.setTitle("SSH APP");
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(300);
            primaryStage.setMinHeight(650);
            primaryStage.show();
            System.out.println("Application started successfully");

        } catch (Exception e) {
            System.out.println("Error starting application: " + e.getMessage());
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Startup Error");
            alert.setHeaderText("Application Failed to Start");
            alert.setContentText("Error: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
