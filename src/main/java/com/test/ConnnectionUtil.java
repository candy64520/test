package com.test;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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
}
