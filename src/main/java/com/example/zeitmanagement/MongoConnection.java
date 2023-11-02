package com.example.zeitmanagement;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

public class MongoConnection {
    static String user = "admin";
    static String password = "admin";
    static String uri = "mongodb+srv://"+ user +":"+ password +"@cluster0.5nwws7b.mongodb.net/?retryWrites=true&w=majority";
    //Verbindung zur Datenbank herstellen
    public static MongoClient createConnectiontoDatabase() {
        MongoClient mongoClient = MongoClients.create(uri);
        try {
            System.out.println("Verbindung zur Datenbank wurde hergestellt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoClient;
    }

    public static Document createDocument(String Mitarbeiternummer, String Vorname, String Nachname, String Vorgesetzter){
        return new Document("id", new ObjectId())
                .append("Mitarbeiterkennung", Mitarbeiternummer)
                .append("Vorname", Vorname)
                .append("Nachname", Nachname)
                .append("Vorgesetzter", Vorgesetzter);
    }
    public static void insertOneDocument(String database, String collection, Document document){
        try{
            MongoClient mongoClient = createConnectiontoDatabase();
            MongoDatabase _database = mongoClient.getDatabase(database);
            MongoCollection<Document> _collection = _database.getCollection(collection);
            _collection.insertOne(document);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void insertManyDocuments(String database, String collection, List<Document> documents) {
        try {
            MongoClient mongoClient = createConnectiontoDatabase();
            MongoDatabase _database = mongoClient.getDatabase(database);
            MongoCollection<Document> _collection = _database.getCollection(collection);
            _collection.insertMany(documents);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //public static void findDocument(Bson query) {

    //}
    //Initialisierung einer ConnectionString-Instanz mit der uri der Datenbank
    public static void main(String[] args) {
        insertOneDocument("test","test",createDocument("111","max","Mustermann","walter"));
    }
}
