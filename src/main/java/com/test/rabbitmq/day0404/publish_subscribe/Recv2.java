package com.test.rabbitmq.day0404.publish_subscribe;

import com.rabbitmq.client.*;
import com.test.rabbitmq.day03.ConnnectionUtil;

import java.io.IOException;

/**
 * @Package: com.test.rabbitmq.day0404.publish_subscribe
 * @ClassName: Recv2
 * @Author: 86150
 * @Description: 注册成功发给邮件服务
 * @Date: 2020/4/4 17:52
 */
public class Recv2 {

    private final static String QUEUE_NAME = "fanout_exchange_queue_email";

    private final static String EXCHANGE_NAME="test_fanout_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();
        final Channel channel = connection.createChannel();

        channel.basicQos(1);


        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
        //定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            //获取信息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("[邮件服务]received:"+msg+" !");

                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,false,consumer);


    }
}
