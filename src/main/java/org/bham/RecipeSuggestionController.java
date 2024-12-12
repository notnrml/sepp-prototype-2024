package org.bham;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecipeSuggestionController extends BaseController {
    private ListView<String> recipeList;

    public RecipeSuggestionController() {
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

        Label titleLabel = new Label("Recipe Suggestions");
        titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        recipeList = new ListView<>();
        recipeList.setPrefHeight(400);
        recipeList.setPrefWidth(250);  // Set preferred width
        recipeList.setStyle("-fx-background-color: white; -fx-background-radius: 5; -fx-border-color: #E6B800;");

        recipeList.setCellFactory(list -> new ListCell<String>() {
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

        // Populate recipes and set up click handler
        populateRecipeList();
        setupRecipeClickHandler();

        Button backButton = createStyledButton("Back");
        backButton.setOnAction(e -> onBack());

        content.getChildren().addAll(titleLabel, recipeList, backButton);
        root.getChildren().addAll(header, content);
        setRoot(root);
    }

    private void populateRecipeList() {
        recipeList.getItems().addAll(
                "Veggie Omelette",
                "Turkey Spinach Salad",
                "Cheesy Turkey Bell Pepper Stuffers",
                "Spaghetti Aglio e Olio",
                "Vegetable Stir-Fry",
                "Chicken Tikka Masala",
                "Avocado Toast",
                "Greek Salad",
                "Beef Tacos",
                "Shakshuka",
                "Miso Soup",
                "Paneer Butter Masala",
                "Classic Burger",
                "Banana Pancakes",
                "Chocolate Brownies"
        );
    }

    private void setupRecipeClickHandler() {
        recipeList.setOnMouseClicked(event -> {
            String selectedRecipe = recipeList.getSelectionModel().getSelectedItem();
            if (selectedRecipe != null) {
                openRecipePage(selectedRecipe);
            }
        });
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

    private void openRecipePage(String recipeName) {
        try {
            RecipePageController controller = new RecipePageController(recipeName);
            Stage stage = (Stage) getRoot().getScene().getWindow();
            stage.setScene(controller.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to open recipe details");
        }
    }

    private void onBack() {
        try {
            IngredientDetectionController controller = new IngredientDetectionController();
            Stage stage = (Stage) getRoot().getScene().getWindow();
            stage.setScene(controller.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to return to ingredient detection");
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
