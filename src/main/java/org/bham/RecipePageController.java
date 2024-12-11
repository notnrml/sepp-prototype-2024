package org.bham;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecipePageController extends BaseController {
    private Label prepTimeLabel;
    private Label servingsLabel;
    private Label tagsLabel;
    private TextArea ingredientsField;
    private TextArea instructionsField;
    private final String recipeName;

    public RecipePageController(String recipeName) {
        super();
        this.recipeName = recipeName;
        setRecipeDetails();
    }

    @Override
    protected void createUI() {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #e1f5f2;");

        HBox header = createHeader();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        VBox content = new VBox(15);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new javafx.geometry.Insets(20));

        Label titleLabel = new Label(recipeName);
        titleLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        prepTimeLabel = new Label();
        prepTimeLabel.setStyle("-fx-font-size: 16;" +
                "-fx-text-fill: black;");

        servingsLabel = new Label();
        servingsLabel.setStyle("-fx-font-size: 16;" +
                "-fx-text-fill: black;");

        tagsLabel = new Label();
        tagsLabel.setStyle("-fx-font-size: 16;" +
                "-fx-text-fill: black;");

        ingredientsField = createStyledTextArea(5);
        instructionsField = createStyledTextArea(7);

        Button doneButton = new Button("Done");
        doneButton.setStyle(
                "-fx-background-color: #787bb2; " +
                        "-fx-text-fill: black; " +
                        "-fx-font-weight: bold; " +
                        "-fx-min-width: 120;"
        );
        doneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDoneClick();
            }
        });

        content.getChildren().addAll(
                titleLabel, prepTimeLabel, servingsLabel,
                tagsLabel, ingredientsField, instructionsField, doneButton
        );

        scrollPane.setContent(content);
        root.getChildren().addAll(header, scrollPane);
        setRoot(root);
    }

    private TextArea createStyledTextArea(int rows) {
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(rows);
        textArea.setPrefWidth(250);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setStyle(
                "-fx-control-inner-background: #d8d9ed; " +
                        "-fx-background-color: white; " +
                        "-fx-background-radius: 5; " +
                        "-fx-border-color: #E6B800; " +
                        "-fx-font-size: 14px;"
        );
        return textArea;
    }

    private void setRecipeDetails() {
        if (recipeName.equals("Veggie Omelette")) {
            prepTimeLabel.setText("Prep Time: 10 minutes");
            servingsLabel.setText("Servings: 1");
            tagsLabel.setText("Tags: Gluten-Free, Vegetarian");

            ingredientsField.setText(
                    "Ingredients:\n- 3 Eggs\n- Spinach (a handful)\n- Bell Peppers (1, diced)\n- Cheddar Cheese (1/4 cup, shredded)"
            );

            instructionsField.setText(
                    "Instructions:\n1. Crack the eggs into a bowl and whisk until well beaten." +
                            "\n2. Add a pinch of salt and pepper to taste." +
                            "\n3. Heat a non-stick pan over medium heat and add a bit of oil." +
                            "\n4. Sauté the diced bell peppers and spinach for 2-3 minutes." +
                            "\n5. Pour the eggs over the veggies and let it cook for 1-2 minutes." +
                            "\n6. Sprinkle the cheddar cheese on top and fold the omelette in half." +
                            "\n7. Cook for another minute or until the cheese melts." +
                            "\n8. Serve warm."
            );
        }
    }

    private void onDoneClick() {
        try {
            RecipeSuggestionController controller = new RecipeSuggestionController();
            Stage stage = (Stage) getRoot().getScene().getWindow();
            stage.setScene(controller.getScene());
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to return to recipe suggestions");
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
