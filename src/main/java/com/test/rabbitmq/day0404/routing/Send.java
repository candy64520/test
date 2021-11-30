package com.test.rabbitmq.day0404.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.test.ConnnectionUtil;

/**
 * @Package: com.test.rabbitmq.day0404.routing
 * @ClassName: Send
 * @Author: 86150
 * @Description: Routing 路由模型
 * @Date: 2020/4/4 19:32
 */
public class Send {
    private final static String EXCHANGE_NAME="test_direct_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为direct
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        String message = "注册成功，请短信回复【T】退订";

        // 发送消息，并且指定routing key 为：sms，只有短信服务能接收到消息
        channel.basicPublish(EXCHANGE_NAME,"sms",null,message.getBytes());

        System.out.println("Send :"+message+" '");
        channel.close();
        connection.close();
    }
}
