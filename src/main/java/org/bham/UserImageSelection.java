package org.bham;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.types.Binary;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserImageSelection {

    public static void main(String[] args) {
       
        MongoDatabase database = connectToMongoDB();
        
        MongoCollection<Document> collection = database.getCollection("ingredients");

        // Hardcoded user (For now, this can be replaced by actual logged-in user)
        String userId = "user-3"; // Change this to "user-2", "user-3", etc., for testing

        clearPreviousUserData(collection, userId);

        // List of ingredients

        //TODO - MAKE HASHMAP WHICH INCLUDES THE USER AND THE DETECTED INGREDIENTS WHICH ARE TO BE ADDED TO THE MONGODB DOCUMENT
        
        //INGREDIENT DETECTION IS NOT IMPLEMENTED FOR THE PROTOTYPE
        
        //AFTER INGREDIENT DETECTION IS DONE - EACH INGREDIENT IMAGE IS STORED AND ALL THE INGREDIENTS ARE STORED IN THE FORM OF A HASHMAP WHICH WILL THEN BE USED TO INPUT IN MONGODB DOCUMENT

        Map<String, List<String>> userIngredients = new HashMap<>();
        userIngredients.put("user-1", List.of("Tomato", "Potato", "Carrot","Apple","Bell Pepper","Cabbage", "Cauliflower", "Chillies", "Lemon"));
        userIngredients.put("user-2", List.of("Cabbage", "Cucumber", "Egg", "Ginger", "Lemon", "Pumpkin", "Tomato"));
        userIngredients.put("user-3", List.of("Cauliflower", "Cucumber", "Egg", "Eggplant", "Ginger","Lemon","Pumpkin","Tomato"));
        userIngredients.put("user-4", List.of("Bell Pepper", "Cabbage", "Carrot","Cucumber","Garlic","Ginger"));
        userIngredients.put("user-5", null);

        List<String> ingredients = userIngredients.get(userId);

        if (ingredients == null) {
            System.out.println("No ingredients found for user: " + userId);
            insertIngredient(collection, null, null, null, userId);
        }else{
            System.out.println("Processing user: " + userId);

             // Process ingredients for the given user

            for (String ingredient : ingredients) {
                // Determine which image to use based on user
                String selectedImagePath = getImageForUser(userId, ingredient);
     
                // Read image and convert it to byte array (Binary)
                byte[] imageData = readImageAsByteArray(selectedImagePath);
    
                // Convert byte array to Binary
                Binary binaryImage = new Binary(imageData);
    
                // Insert the ingredient with its image into MongoDB
                insertIngredient(collection, ingredient, getIngredientIdFromPostgreSQL(ingredient), binaryImage,userId);
            }
            System.out.println("All the ingredients were added successfully");
        }
    
       
    }

    private static MongoDatabase connectToMongoDB() {
        String mongoURI = "mongodb://localhost:27017"; // MongoDB URI
        MongoClient mongoClient = MongoClients.create(mongoURI);
        return mongoClient.getDatabase("ingredient_database");
    }

    private static void clearPreviousUserData(MongoCollection<Document> collection, String userId) {
        collection.deleteMany(new Document());
        System.out.println("Cleared previous data for user: " + userId);
    }

    // Method to determine image based on user
    protected static String getImageForUser(String userId, String ingredientName) {
        // Build the path based on userId and ingredient name
        String imagePath = "C:/Users/nrmls/Desktop/backend-trial/src/main/java/org/bham/" + "resources/" + userId + "/" + ingredientName.toLowerCase() + ".png";
        return imagePath;
    }

    // Method to insert ingredient with image data
    private static void insertIngredient(MongoCollection<Document> collection, String ingredientName, String ingredientId, Binary imageData, String userId) {
        Document ingredientDoc = new Document("User_id", userId)
                .append("ingredient_name", ingredientName)
                .append("ingredient_id", ingredientId)
                .append("image_data", imageData);
        collection.insertOne(ingredientDoc);
    }

    protected static String getIngredientIdFromPostgreSQL(String ingredientName) {
        // JDBC connection details (replace with your actual database details)
        String url = "jdbc:postgresql://localhost:5432/recipe_app";
        String user = "postgres";
        String password = "Nrml";

        String ingredientId = null;

        String query = "SELECT ingredient_id FROM \"Ingredients\" WHERE name = ?";
        

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            // Set the ingredient name in the query
            preparedStatement.setString(1, ingredientName.trim());
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // If the ingredient exists, get its ID  else exception
            if (resultSet.next()) {
                ingredientId = resultSet.getString("ingredient_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientId;
    }

    // Method to read image file as byte array
    protected static byte[] readImageAsByteArray(String imagePath) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(imagePath))) {
            byte[] imageData = new byte[(int) new File(imagePath).length()];
            fileInputStream.read(imageData);
            return imageData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

