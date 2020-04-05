package com.test.rabbitmq.day0404.publish_subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.test.ConnnectionUtil;

/**
 * @Package: com.test.rabbitmq.day0404.publish_subscribe
 * @ClassName: Send
 * @Author: 86150
 * @Description: 推送订阅
 *
 *  声明Exchange，不再声明Queue
 *
 * 2） 发送消息到Exchange，不再发送到Queue
 * @Date: 2020/4/4 17:33
 */
public class Send {

    private final static String  EXCHANG_NAME="test_fanout_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //声明exchange 指定类型为fanout
        channel.exchangeDeclare(EXCHANG_NAME,"fanout");
        for (int i=0;i<50;i++){
            //消息内容
            String message = "2020注册成功！！"+i;
            channel.basicPublish(EXCHANG_NAME,"",null,message.getBytes());
            System.out.println("生产者 sent ‘"+message+" '");
        }


        channel.close();
        connection.close();

    }
}
