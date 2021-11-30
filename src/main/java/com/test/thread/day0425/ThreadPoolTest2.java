package com.test.thread.day0425;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.test.thread.day0425
 * @ClassName: ThreadPoolTest2
 * @Author: 86150
 * @Description: 理解线程池
 * @Date: 2020/4/25 20:01
 */
public class ThreadPoolTest2 {

        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 10; i++) {
                executor.submit(() -> {
                    System.out.println("thread id is: " + Thread.currentThread().getId());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        //4. 创建定时调度的线程池
        // 创建定时调度的线程池
        //public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize);
        @Test
        public void test(){
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

            // 定时调度，每个调度任务会至少等待`period`的时间，
            // 如果任务执行的时间超过`period`，则等待的时间为任务执行的时间
            executor.scheduleAtFixedRate(() -> {
                try {
                    Thread.sleep(1);
                    System.out.println("------"+System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, 0, 2, TimeUnit.SECONDS);

            // 定时调度，第二个任务执行的时间 = 第一个任务执行时间 + `delay`
            executor.scheduleWithFixedDelay(() -> {
                try {
                    Thread.sleep(2);
                    System.out.println("**********"+System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, 0, 2, TimeUnit.SECONDS);

            // 定时调度，延迟`delay`后执行，且只执行一次
            executor.schedule(() -> System.out.println("5 秒之后执行 schedule"), 5, TimeUnit.SECONDS);
        }
}
