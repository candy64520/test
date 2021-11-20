package com.test.springboot_test.redis;

/**
 * @Package: com.test.springboot_test.redis
 * @ClassName: RedisTest
 * @Author: 86150
 * @Description:
 * @Date: 2021/7/4 12:39
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.springboot_test.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    // 在导入 redis 依赖，并且配置 redis 连接信息之后，springboot 会
    // 自动帮我们创建一个 redis 模板，存在 ioc 容器中；
    // 如果我们需要使用，直接从 IOC 容器中获取即可；
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void test() throws JsonProcessingException {
        // 1、从 redis 中获取缓存数据，数据的形式一般使用 json 字符串
        String userListJson = redisTemplate.opsForValue().get("name");

        // 2、判断 redis 中是否存在数据
        if (userListJson == null || userListJson.isEmpty()){

            // 4.2、再将数据存储到 redis 缓存中
            redisTemplate.opsForValue().set("name","2021-07-66");

            System.out.println("================ 从数据库中获取数据 ================");
        }else{
            redisTemplate.opsForValue().set("name","2021-07-66");
            System.out.println("================ 从redis中获取数据 ================");
        }

        // 4、将数据输出到控制台
        System.out.println(userListJson);
    }
}