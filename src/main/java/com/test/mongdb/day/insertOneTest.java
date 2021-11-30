package com.test.mongdb.day;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.test.mongdb.day
 * @ClassName: insertOneTest
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/20 19:28
 */
public class insertOneTest {

    //插入一个文档
    @Test
    public void insertOneTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //要插入的数据
        Document document = new Document("name","张三")
                .append("sex", "男")
                .append("age", 18);
        //插入一个文档
        collection.insertOne(document);
    }


    //插入多个文档
    @Test
    public void insertManyTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("col");
        //要插入的数据
        List<org.bson.Document> list = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            org.bson.Document document = new Document("name", "张三"+i)
                    .append("sex", "男")
                    .append("age", 18);
            list.add(document);
        }
        //插入多个文档
        collection.insertMany(list);
    }

    //查找集合中的所有文档
    @Test
    public void findTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //查找集合中的所有文档
        FindIterable findIterable = collection.find();
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    //指定查询过滤器查询
    @Test
    public void FilterfindTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //指定查询过滤器
        Bson filter = Filters.eq("name", "张三");
        //指定查询过滤器查询
        FindIterable findIterable = collection.find(filter);
        MongoCursor cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    //取出查询到的第一个文档
    @Test
    public void findTest2(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //查找集合中的所有文档
        FindIterable findIterable = collection.find();
        //取出查询到的第一个文档
        Document document = (Document) findIterable.first();
        //打印输出
        System.out.println(document);
    }

    //删除与筛选器匹配的单个文档
    @Test
    public void deleteOneTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //申明删除条件
        Bson filter = Filters.eq("age",18);
        //删除与筛选器匹配的单个文档
        collection.deleteOne(filter);
    }

    //删除与筛选器匹配的所有文档
    @Test
    public void deleteManyTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //申明删除条件
        Bson filter = Filters.eq("age",18);
        //删除与筛选器匹配的所有文档
        collection.deleteMany(filter);
    }

    //修改单个文档
    @Test
    public void updateOneTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //修改过滤器
        Bson filter = Filters.eq("name", "张三");
        //指定修改的更新文档
        Document document = new Document("$set", new Document("age", 100));
        //修改单个文档
        collection.updateOne(filter, document);
    }


    //修改多个文档
    @Test
    public void updateManyTest(){
        //获取数据库连接对象
        MongoDatabase mongoDatabase = MongoDBUtil.getConnect();
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("col");
        //修改过滤器
        Bson filter = Filters.eq("name", "张三");
        //指定修改的更新文档
        Document document = new Document("$set", new Document("age", 100));
        //修改多个文档
        collection.updateMany(filter, document);
    }


}
