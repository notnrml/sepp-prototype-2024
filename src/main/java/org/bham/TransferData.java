package org.bham;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class TransferData {

    public static void main(String[] args) {
        // MongoDB connection setup
        MongoDatabase mongoDatabase = connectToMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("ingredients");

        // PostgreSQL connection setup
        Connection postgreSQLConnection = connectToPostgreSQL();

        // Hardcoded user_id (replace with actual user logic)
        String userId = "user-1";

        try {
            // Query MongoDB for all documents matching the user_id
            MongoCursor<Document> cursor = collection.find(new Document("User_id", userId)).iterator();

            // List to store ingredient IDs
            List<Integer> ingredientIdsList = new ArrayList<>();

            // Extract all ingredient IDs
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                String ingredientIdStr = doc.getString("ingredient_id");
                if (ingredientIdStr != null) {
                    try {
                        ingredientIdsList.add(Integer.parseInt(ingredientIdStr));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ingredient ID: " + ingredientIdStr);
                    }
                }
            }

            if (!ingredientIdsList.isEmpty()) {
                // Convert List<Integer> to Integer[]
                Integer[] ingredientIds = ingredientIdsList.toArray(new Integer[0]);

                // Insert into PostgreSQL
                insertIntoPostgres(postgreSQLConnection, userId, ingredientIds);
            } else {
                System.out.println("No ingredients found for user: " + userId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close PostgreSQL connection
            if (postgreSQLConnection != null) {
                try {
                    postgreSQLConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static MongoDatabase connectToMongoDB() {
        String mongoURI = "mongodb://localhost:27017";
        return com.mongodb.client.MongoClients.create(mongoURI).getDatabase("ingredient_database");
    }

    public static Connection connectToPostgreSQL() {
        String url = "jdbc:postgresql://localhost:5432/recipe_app";
        String user = "postgres";
        String password = "Nrml";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to PostgreSQL.");
        }
    }

    public static void insertIntoPostgres(Connection connection, String userId, Integer[] ingredientIds) {
        String insertQuery = "INSERT INTO \"Fridge_Items\" (\"User_id\", \"allingredient_id\") VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            // Set the user ID
            preparedStatement.setString(1, userId);

            // Create an SQL array for ingredient IDs
            Array ingredientArray = connection.createArrayOf("INTEGER", ingredientIds);
            preparedStatement.setArray(2, ingredientArray);

            // Execute the insert query
            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully for user: " + userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
