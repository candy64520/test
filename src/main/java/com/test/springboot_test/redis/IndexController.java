package com.test.springboot_test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.*;

import javax.sound.midi.Soundbank;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.test.springboot_test.redis
 * @ClassName: IndexController
 * @Author: 86150
 * @Description:模拟秒杀
 * @Date: 2021/7/5 13:58
 */
@RestController
public class IndexController {

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public String deductStock(){

        /**
         * 不加 synchronized  出现超卖，同时3个线程进来，都是49，那么就是超卖
         * synchronized  也是超卖，因为synchronized 只能在Tomcat执行，启动两个，就有两个Tomcat，在分布式高并发的情况下，也会出现超卖
         *
         * redis 是单线程模型，就算所有的并发请求同时达到redis，也进行排队，使用setnx 分布式锁，只有一个线程执行成功
         *
         */

        String lockKey = "procduct_001";
        //解决  高并发下锁永久失效的问题
        String clientId = UUID.randomUUID().toString();
        try {
          /*  Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey,"candy");
            stringRedisTemplate.expire(lockKey,10, TimeUnit.SECONDS);//10s就过期*/
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey,clientId,10,TimeUnit.SECONDS);
            if(!result){
                System.out.println("error!!!!");
                return "error";
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock>0){
                int realStock=stock-1;
                stringRedisTemplate.opsForValue().set("stock",realStock+"");//宕机，运行到这里就会出错，比如运维发布项目，刚好到这步就中断，那么这里的锁就没有释放，死锁。解决方法，设计过期时间 stringRedisTemplate.expire(lockKey,10, TimeUnit.SECONDS);//10s就过期
                System.out.println("扣减成功，剩余库存："+realStock+"");

            }else {
                System.out.println("扣减失败，库存不足！");
            }

//        }
        }finally {
            //解决  高并发下锁永久失效的问题
            if(clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))){
                //释放锁
                stringRedisTemplate.delete(lockKey);
            }

        }

        return "end";

    }
}
