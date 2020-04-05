package com.test.rabbitmq.day0404.routing;

import com.rabbitmq.client.*;
import com.test.rabbitmq.day03.ConnnectionUtil;


/**
 * @Package: com.test.rabbitmq.day0404.routing
 * @ClassName: Recv
 * @Author: 86150
 * @Description: 路由模型
 * @Date: 2020/4/4 19:40
 */
public class Recv {
    private final static String QUEUE_NAME="direct_exchange_sms";//短信队列
    private final static String EXCHANGE_NAME="test_direct_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //绑定队列到交换机，同事指定需要订阅的routing key,可以指定多个
        //指定接收发送方指定routing key为sms的消息
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"sms");

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,byte[] body){
                String msg = new String(body);
                System.out.println("[短信服务] recevied："+msg+ " !");
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
