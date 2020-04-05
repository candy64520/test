package com.test.rabbitmq.day0405.topic;

import com.rabbitmq.client.*;
import com.test.ConnnectionUtil;

/**
 * @Package: com.test.rabbitmq.day0405.topic
 * @ClassName: Recv2
 * @Author: 86150
 * @Description: topic
 * @Date: 2020/4/5 9:58
 */
public class Recv2 {
    private final static String QUEUE_NAME="topic_exchange_queue_02";
    private final static String EXCHANGE_NAME="test_topic_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"*.*.rabbit");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"lazy.#");

        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTage, Envelope envelope , AMQP.BasicProperties basicproperties,
                                       byte[] body){
                String msg = new String(body);
                System.out.println("[消费者2] received"+msg +" '" );
            }
        };
        channel.basicConsume(QUEUE_NAME,true,consumer);

    }
}
