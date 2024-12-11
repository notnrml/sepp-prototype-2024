package org.bham;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IngredientDetectionController extends BaseController {
    private ListView<String> ingredientList;

    public IngredientDetectionController() {
        super();
    }

    @Override
    protected void createUI() {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #e1f5f2;");

        HBox header = createHeader();

        VBox content = new VBox(15);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new javafx.geometry.Insets(20));

        Label titleLabel = new Label("Fridge Contents");
        titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        ingredientList = new ListView<>();
        ingredientList.setPrefHeight(300);
        ingredientList.setPrefWidth(250);
        ingredientList.setStyle("-fx-background-color: white; -fx-background-radius: 5; -fx-border-color: #474a7d;");


        ingredientList.setCellFactory(list -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle(null);
                } else {
                    setText(item);
                    setStyle(
                            "-fx-background-color: #d8d9ed; " +
                                    "-fx-padding: 10px; " +
                                    "-fx-text-fill: black; " +
                                    "-fx-font-size: 14px;"
                    );
                }
            }
        });

        // Populate the list
        populateIngredientList();

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);  // Add spacing between buttons

        Button backButton = createStyledButton("Back");
        backButton.setOnAction(e -> onBack());

        Button viewRecipesButton = createStyledButton("View Recipes");
        viewRecipesButton.setOnAction(e -> onViewRecipesClick());

        buttonBox.getChildren().addAll(backButton, viewRecipesButton);
        content.getChildren().addAll(titleLabel, ingredientList, buttonBox);
        root.getChildren().addAll(header, content);
        setRoot(root);
    }

    private void populateIngredientList() {
        ingredientList.getItems().addAll(
                "Eggs",
                "Milk",
                "Turkey",
                "Cheddar Cheese",
                "Spinach",
                "Bell Peppers",
                "Carrots",
                "Tomatoes",
                "Mushrooms"
        );
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #787bb2; " +
                "-fx-text-fill: black; " +
                "-fx-font-weight: bold; " +
                "-fx-min-width: 120;");
        button.setPadding(new javafx.geometry.Insets(10));
        return button;
    }

    private void onViewRecipesClick() {
        try {
            RecipeSuggestionController controller = new RecipeSuggestionController();
            Stage stage = (Stage) getRoot().getScene().getWindow();
            stage.setScene(controller.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load recipe suggestions");
        }
    }

    private void onBack() {
        try {
            MainPageController controller = new MainPageController();
            Stage stage = (Stage) getRoot().getScene().getWindow();
            stage.setScene(controller.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to return to main page");
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
