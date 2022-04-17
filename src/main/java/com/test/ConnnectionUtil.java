package com.test;


import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.util.*;

public class ConnnectionUtil {


    /**
     * 建立与rabbitmq的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.31");
        factory.setPort(5672);
        //设置虚拟机，一个MQ服务可以设置多个虚拟机，每个虚拟机相当于一个独立的MQ
        factory.setVirtualHost("VHOST");
        factory.setUsername("candy");
        factory.setPassword("1234");
        Connection connection = factory.newConnection();
        return connection;
    }

    public void test3(){
        System.out.println("9999");
    }


    public static void main(String[] args) {

        Map<String,Integer> map1= new HashMap<String, Integer>();
        map1.put("one",1);
        map1.put("two",2);
        map1.put("three",3);
        Map<String,Integer> map2= new HashMap<String,Integer>();
        map2.put("one",1);
        map2.put("two",2);
        //map1合并到map2中
        map1.forEach((key,value) -> map2.merge(key,value,Integer::sum));
        System.out.println(JSON.toJSONString(map2));
        
    }

    @Test
    public void test2(){
        //存测试数据,模仿从数据库读出的数据

        List<user> list = new ArrayList<>();
        user u1 = new user("李四", 20);
        user u2 = new user("张三", 30);
        user u3 = new user("隔壁老王", 18);
        user u4 = new user("劈腿老罗", 18);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);

//最终merge的数据
        Map map = new HashMap<>();

        list.forEach(uVo -> {
//new HashSet(){undefined{}}这是什么写法，我也不知道。感觉很帅
            map.merge(uVo.getAge(), new HashSet() {
                {
                add(uVo.getName());
                }
            }, (oldV, newV) -> {
                oldV=newV;
                return oldV;
            });
        });

        System.out.println(map);

    }
}
