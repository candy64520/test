package com.test.test4;

/**
 * @Package: com.test.test4
 * @ClassName: VolatileExample
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/7 15:58
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 变量的内存可见性例子
 *
 * @author star
 */
public class VolatileExample {

    /**
     * main 方法作为一个主线程
     */
    public static void main(String[] args) {

        ReentrantLock reentrantLock =new ReentrantLock();
        MyThread myThread = new MyThread();
        // 开启线程
        myThread.start();

        // 主线程执行
        for (; ; ) {
            if (myThread.isFlag()) {
                System.out.println("主线程访问到 flag 变量");
            }
        }
    }

}

/**
 * 子线程类
 */
class MyThread extends Thread {

    private volatile  boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 修改变量值
        flag = true;
        System.out.println("flag = " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
