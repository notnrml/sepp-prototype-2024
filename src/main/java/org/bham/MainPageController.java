package org.bham;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPageController extends BaseController {

    public MainPageController() {
        super();
    }

    @Override
    protected void createUI() {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #e1f5f2;");

        HBox header = createHeader();

        VBox content = new VBox(40);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new javafx.geometry.Insets(20));

        Label titleLabel = new Label("SSH APP");
        titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        VBox ingredientSection = createSection("/images/ingredient2-Photoroom.png", "SSH INGREDIENT\nSUGGESTION");
        Button ingredientButton = (Button) ingredientSection.getChildren().get(1);
        ingredientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onIngredientClick();
            }
        });

        VBox grocerySection = createSection("/images/grocery-Photoroom.png", "SSH GROCERY");
        Button groceryButton = (Button) grocerySection.getChildren().get(1);
        groceryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onGroceryClick();
            }
        });

        VBox schedulerSection = createSection("/images/calendar-Photoroom.png", "SSH SMART\nSCHEDULAR");
        Button schedulerButton = (Button) schedulerSection.getChildren().get(1);
        schedulerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onSchedulerClick();
            }
        });

        content.getChildren().addAll(titleLabel, ingredientSection, grocerySection, schedulerSection);
        root.getChildren().addAll(header, content);
        setRoot(root);
    }

    private VBox createSection(String imagePath, String buttonText) {
        VBox section = new VBox(10);
        section.setAlignment(Pos.CENTER);

        // Create ImageView for the icon
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(image);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            imageView.setPreserveRatio(true);
        } catch (Exception e) {
            System.out.println("Failed to load image: " + imagePath);
        }

        Button button = new Button(buttonText);
        button.setStyle(
                "-fx-background-color: transparent; " +
                        "-fx-text-fill: #787bb2; " +
                        "-fx-font-weight: bold; " +
                        "-fx-font-size: 14px; " +
                        "-fx-min-width: 200; " +
                        "-fx-border-width: 0;"
        );
        button.setWrapText(true);

        section.getChildren().addAll(imageView, button);
        return section;
    }

    private void onIngredientClick() {
        try {
//            showAlert("Navigation", "Going to Ingredient Detection Page");

            IngredientDetectionController controller = new IngredientDetectionController();
            Stage stage = (Stage) getRoot().getScene().getWindow();
            stage.setScene(controller.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to open Ingredient Detection page");
        }
    }

    private void onGroceryClick() {

    }
    private void onSchedulerClick() {

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
