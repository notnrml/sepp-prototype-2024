package org.bham;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public abstract class BaseController {
    private Scene scene;
    private Region root;
    protected ImageView logoView;

    protected BaseController() {
        System.out.println("BaseController constructor called");
        scene = new Scene(new Region(), 300, 650);
        createUI();
        System.out.println("BaseController UI created");
    }

    protected abstract void createUI();

    protected HBox createHeader() {
        try {
            HBox header = new HBox(10);
            header.setAlignment(Pos.CENTER_LEFT);
            header.setPadding(new javafx.geometry.Insets(10));
            header.setStyle("-fx-background-color: #474a7d;");

            logoView = new ImageView();
            try {
                Image logo = new Image(getClass().getResourceAsStream("/images/logo.png"));
                logoView.setImage(logo);
            } catch (Exception e) {
                System.out.println("Failed to load logo image: " + e.getMessage());
            }
            logoView.setFitHeight(80);
            logoView.setFitWidth(80);
            logoView.setPreserveRatio(true);
            
            header.getChildren().add(logoView);
            return header;

        } catch (Exception e) {
            System.out.println("Error creating header: " + e.getMessage());
            e.printStackTrace();
            return new HBox(); // Return empty header in case of error
        }
    }

    protected void setRoot(Region root) {
        if (root == null) {
            System.out.println("Warning: Attempting to set null root");
            return;
        }
        this.root = root;
        scene.setRoot(root);
        System.out.println("Root set successfully");
    }

    protected Region getRoot() {
        return root;
    }

    public Scene getScene() {
        if (scene == null) {
            System.out.println("Warning: Scene is null");
            return new Scene(new Region(), 300, 650);
        }
        return scene;
    }
}
