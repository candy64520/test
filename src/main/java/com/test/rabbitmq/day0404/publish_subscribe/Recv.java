package com.test.rabbitmq.day0404.publish_subscribe;

import com.rabbitmq.client.*;
import com.test.rabbitmq.day03.ConnnectionUtil;

import java.io.IOException;

/**
 * @Package: com.test.rabbitmq.day0404.publish_subscribe
 * @ClassName: Recv
 * @Author: 86150
 * @Description: 注册成功发送给短信服务
 * @Date: 2020/4/4 17:43
 */
public class Recv {
    private final static String QUEUE_NAME = "fanout_exchange_queue_sms";//短信队列

    private final static String EXCHANGE_NAME = "test_fanout_exchange";

    public static void main(String[] argv) throws IOException {
        // 获取到连接
        Connection connection = null;
        try {
            connection = ConnnectionUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取通道
        final Channel channel = connection.createChannel();

        channel.basicQos(1);

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机
       channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // body 即消息体
                String msg = new String(body);
                System.out.println(" [短信服务] received : " + msg + "!");

                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        // 监听队列，自动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
