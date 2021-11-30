package com.test.day8;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.test.day8
 * @ClassName: SecTime
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/12 16:08
 */
    public class MyScheduleExecutorService {
        public static void main(String[] args) {
            // 创建任务队列，并且设置线程数量为10
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
            // 执行任务
            scheduledExecutorService.scheduleAtFixedRate(()->{
                System.out.println("执行定时任务"+ new Date());
            },1,3, TimeUnit.SECONDS);
        }
    }

