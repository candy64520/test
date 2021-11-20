package com.test.test;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Package: com.test.test
 * @ClassName: Test2
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/13 14:07
 */
class SynchronizedTest {

        public static volatile int race = 0;

        private static CountDownLatch countDownLatch = new CountDownLatch(2);

        public static void main(String[] args) throws InterruptedException {
            // 循环开启2个线程来计数
            for (int i = 0; i < 2; i++) {
                new Thread(() -> {
                    // 每个线程累加1万次
                    for (int j = 0; j < 10000; j++) {
                        synchronized (SynchronizedTest.class) {
                            race++;
                        }
                    }
                    countDownLatch.countDown();
                }).start();
            }
            // 等待，直到所有线程处理结束才放行
            countDownLatch.await();
            // 期望输出 2万（2*1万）
            System.out.println(race);

            getLock();
        }



        private static final Object lock = new Object();

        public static void testWait() throws InterruptedException {
            lock.wait();
        }

        public static void testNotify() throws InterruptedException {
            lock.notify();
        }



        public static synchronized void getLock() throws InterruptedException {
            lock.wait();
        }
}

