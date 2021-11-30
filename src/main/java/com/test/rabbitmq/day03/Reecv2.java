package com.test.rabbitmq.day03;


import com.rabbitmq.client.*;
import com.test.ConnnectionUtil;

import java.io.IOException;

/**
 * @Package: com.test.day03.rabbitmq
 * @ClassName: Reecv2
 * @Author: 86150
 * @Description: 手动ACK
 * @Date: 2020/3/29 16:05
 */
public class Reecv2 {
    private final static String QUEUE_NAME="hm_simple_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        final DefaultConsumer consumer = new DefaultConsumer(channel){
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,byte[] body) throws IOException {

//                int i = 1/0;
                String msg = new String( body);
                System.out.println("received : "+msg);
                // 手动进行ACK
                /*
                 *  void basicAck(long deliveryTag, boolean multiple) throws IOException;
                 *  deliveryTag:用来标识消息的id
                 *  multiple：是否批量.true:将一次性ack所有小于deliveryTag的消息。
                 */
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };

        //监听队列，第二个参数为false  手动进行ack
        channel.basicConsume(QUEUE_NAME,false,consumer);














    }
}
