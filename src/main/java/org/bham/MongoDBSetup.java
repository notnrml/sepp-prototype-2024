package org.bham;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBSetup {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("ingredient_database");
            String collectionName = "ingredients";

            // Check if the collection exists
            if (!collectionExists(database, collectionName)) {
                System.out.println("Collection does not exist. Creating and initializing...");
                MongoCollection<Document> collection = database.getCollection(collectionName);

                // Insert a default document (structure only)
                Document defaultDocument = new Document("ingredient_id", null)
                        .append("ing_name", null)
                        .append("image", null); // Placeholder for image
                collection.insertOne(defaultDocument);
            } else {
                System.out.println("Collection exists. Skipping setup.");
            }
        }
    }

    private static boolean collectionExists(MongoDatabase database, String collectionName) {
        return database.listCollectionNames().into(new ArrayList<>()).contains(collectionName);
    }
}

