package com.test.rabbitmq.day0405.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.test.ConnnectionUtil;

/**
 * @Package: com.test.rabbitmq.day0405
 * @ClassName: Send
 * @Author: 86150
 * @Description: Topics 通配符模式
 * @Date: 2020/4/5 9:29
 */
public class Send {
    private final static String EXCHANGE_NAME="test_topic_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        String msg = "Topic 这是一只运动迅速的橙色的兔子";
        // 发送消息，并且指定routing key为：quick.orange.rabbit
        channel.basicPublish(EXCHANGE_NAME,"quick.orange.rabbit",null,msg.getBytes());

        System.out.println("[动物描述] sent "+msg+" '");
        channel.close();
        connection.close();

    }
}
