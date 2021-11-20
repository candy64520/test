package com.test.day8;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @Package: com.test.day8
 * @ClassName: Rejected
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/13 9:45
 */
public class Rejected {
    public static void main(String[] args) throws Exception{
        int corePoolSize = 2;
        int maximumPoolSize = 10;
        long keepAliveTime = 5;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(2);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy  ();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, handler);
        for(int i=0; i<100; i++) {
            try {
                executor.execute(new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running")));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e);
            }
        }
        executor.shutdown();

        HashMap hashMap = new HashMap();
    }

    @Test
    public  void cachedThreadPool() {
        // 创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 执行任务
        for (int i = 0; i < 30000; i++) {
            threadPool.execute(() -> {
                System.out.println("任务被执行,线程:" + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
            });
        }
    }
    @Test
    public  void workStealingPool() {
        /*// 创建线程池
        ExecutorService threadPool = Executors.newWorkStealingPool();
        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                System.out.println(index + " 被执行,线程名:" + Thread.currentThread().getName());
            });
        }
        // 确保任务执行完成
        while (!threadPool.isTerminated()) {
        }*/

        int key = 16;
        System.out.println(Integer.toBinaryString("郭德纲".hashCode()));
    }
}
