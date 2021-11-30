package com.test.mongdb.day;

/**
 * @Package: com.test.mongdb.day
 * @ClassName: InsertDocument
 * @Author: 86150
 * @Description:  插入集合
 * @Date: 2021/11/20 19:42
 */

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InsertDocument {

    public static void main(String[] args) {

        try {

            // mongodb server
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //databases
            MongoDatabase database = mongoClient.getDatabase("testroob");

            System.out.println("Collection created successfully");

            System.out.println("当前数据库中的所有集合是：");

            for (String name : database.listCollectionNames()) {
                System.out.println(name);
            }

            MongoCollection<Document> coll = database.getCollection("col");
            System.out.println("Collection test selected successfully");
            MongoCollection<Document> collection = database.getCollection("col");

            Document document = new Document("_id", 1999).append("title", "MongoDB Insert Demo")
                    .append("description","database")
                    .append("likes", 30)
                    .append("by", "demo point")
                    .append("url", "http://www.demo.com/mongodb/");

            collection.insertOne(document);

            collection.find().forEach(printBlock);

            System.out.println("Document inserted successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    static Block<Document> printBlock = new Block<Document>() {
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };
}
