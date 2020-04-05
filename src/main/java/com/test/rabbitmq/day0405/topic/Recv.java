package com.test.rabbitmq.day0405.topic;

import com.rabbitmq.client.*;
import com.test.ConnnectionUtil;

/**
 * @Package: com.test.rabbitmq.day0405.topic
 * @ClassName: Recv
 * @Author: 86150
 * @Description: topic
 * @Date: 2020/4/5 9:48
 */
public class Recv {

    private final static String QUEUE_NAME="topic_exchange_queue_Q1";
    private final static String EXCHANG_NAME="test_topic_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANG_NAME,"*.orange.*");

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTage, Envelope envelope , AMQP.BasicProperties basicproperties,
                                       byte[] body){
                String msg = new String(body);
                System.out.println("[l消费者1] received："+msg+"!");
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
