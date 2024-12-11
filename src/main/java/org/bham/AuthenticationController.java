package org.bham;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AuthenticationController extends BaseController {

    private TextField usernameField;
    private PasswordField passwordField;

    public AuthenticationController() {
        super();
    }

    @Override
    protected void createUI() {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #e1f5f2;");

        HBox header = createHeader();

        // Main content wrapper with padding to center vertically
        VBox contentWrapper = new VBox();
        contentWrapper.setAlignment(Pos.CENTER);
        contentWrapper.setPrefHeight(500);  // This helps center the content vertically

        VBox content = new VBox(15);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new javafx.geometry.Insets(10, 20, 20, 20));

        Label signInLabel = new Label("Sign in");
        signInLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Label welcomeLabel = new Label("Welcome to the SSH app");
        welcomeLabel.setStyle("-fx-font-size: 15;");

        // Email Field Section
        Label emailLabel = new Label("Email");
        emailLabel.setStyle("-fx-font-size: 12;");
        usernameField = new TextField();
        usernameField.setPromptText("Enter your email");
        usernameField.setPrefWidth(250);
        usernameField.setPrefHeight(35);
        usernameField.setStyle(
                "-fx-background-color: white; " +
                        "-fx-background-radius: 5;"
        );

        // Password Field Section
        Label passwordLabel = new Label("Password");
        passwordLabel.setStyle("-fx-font-size: 12;");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setPrefWidth(250);
        passwordField.setPrefHeight(35);
        passwordField.setStyle(
                "-fx-background-color: white; " +
                        "-fx-background-radius: 5;"
        );

        // Sign In Button
        Button signInButton = new Button("SIGN IN");
        signInButton.setPrefWidth(250);
        signInButton.setPrefHeight(35);
        signInButton.setStyle(
                "-fx-background-color: #787bb2; " +
                        "-fx-text-fill: black; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 20;"
        );
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSignIn();
            }
        });

        // Add spacing between sections
        VBox emailBox = new VBox(5);
        emailBox.setAlignment(Pos.CENTER_LEFT);
        emailBox.getChildren().addAll(emailLabel, usernameField);

        VBox passwordBox = new VBox(5);
        passwordBox.setAlignment(Pos.CENTER_LEFT);
        passwordBox.getChildren().addAll(passwordLabel, passwordField);

        content.getChildren().addAll(
                signInLabel,
                welcomeLabel,
                new Region() { { setMinHeight(20); } },
                emailBox,
                new Region() { { setMinHeight(5); } },
                passwordBox,
                new Region() { { setMinHeight(20); } },
                signInButton
        );

        contentWrapper.getChildren().add(content);
        root.getChildren().addAll(header, contentWrapper);
        setRoot(root);
    }

    private void handleSignIn() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("bham") && password.equals("bham")) {
            try {
                MainPageController controller = new MainPageController();
                Stage stage = (Stage) getRoot().getScene().getWindow();
                stage.setScene(controller.getScene());
            } catch (Exception e) {
                e.printStackTrace();
                showAlert("Error", "Failed to open main page");
            }
        } else {
            showAlert("Invalid Login", "Incorrect email or password.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
