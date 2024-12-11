package org.bham;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        Button helloButton = new Button("Say Hello!");


        helloButton.setOnAction(event -> {
            System.out.println("Hello, World!");
        });


        StackPane root = new StackPane();
        root.getChildren().add(helloButton);


        Scene scene = new Scene(root, 300, 200);


        primaryStage.setTitle("HelloApplication");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
