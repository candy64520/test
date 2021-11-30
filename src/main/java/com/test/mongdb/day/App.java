package com.test.mongdb.day;

/**
 * @Package: com.test.mongdb.day
 * @ClassName: App
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/20 19:40
 */

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class App {

    public static void main(String[] args) {
        try {
            //连接MongoDB 服务器
            MongoClient mongoClient =
                    new MongoClient("localhost", 27017);
            //连接数据库
            MongoDatabase mDatabase =
                    mongoClient.getDatabase("testroob");  //test可选

            System.out.println("Connect to database successfully!");
            System.out.println("MongoDatabase inof is : "+mDatabase.getName());
        } catch (Exception e) {
            System.err.println(
                    e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
