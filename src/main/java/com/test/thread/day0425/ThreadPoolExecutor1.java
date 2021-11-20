package com.test.thread.day0425;


import lombok.Data;

import java.util.concurrent.*;

/**
 * @Package: com.test.thread.day0425
 * @ClassName: ThreadPoolExecutor
 * @Author: 86150
 * @Description: 线程池学校
 * @Date: 2020/4/25 14:46
 */
@Data
public class ThreadPoolExecutor1 {

    private final int corePoolSize;
    private final int maximumPoolSize;
    private final int keepAliveTime;

    private final BlockingQueue<Runnable> workQueue;
    private final ThreadFactory threadFactory;
    private final RejectedExecutionHandler handler;

    public ThreadPoolExecutor1(int corePoolSize, // 1
                              int maximumPoolSize,  // 2
                              long keepAliveTime,  // 3
                              TimeUnit unit,  // 4
                              BlockingQueue<Runnable> workQueue, // 5
                              ThreadFactory threadFactory,  // 6
                              RejectedExecutionHandler handler ) { //7
        if (corePoolSize < 0 ||
                maximumPoolSize <= 0 ||
                maximumPoolSize < corePoolSize ||
                keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = (int) unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
































}
