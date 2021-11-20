package com.test.mongdb.day;

/**
 * @Package: com.test.mongdb.day
 * @ClassName: CreateCollection
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/20 19:41
 */

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CreateCollection {

    public static void main(String[] args) {
        try {

            // mongodb server
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            //databases
            MongoDatabase database = mongoClient.getDatabase("testroob");

            MongoCollection<Document> coll = database.getCollection("col");

            System.out.println("Collection created successfully");

            System.out.println("当前数据库中的所有集合是：");

            for (String name : database.listCollectionNames()) {
                System.out.println(name);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}