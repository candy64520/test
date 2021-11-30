package com.test.thread;

/**
 * @Package: com.test.thread
 * @ClassName: test
 * @Author: 86150
 * @Description:
 * @Date: 2021/9/8 18:18
 */
public class test {

     static class MyThread extends Thread {
        @Override
        public  void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println("i="+(i+1));
            }
        }
    }

     static class Do {

        public static void main(String[] args ) {
            MyThread thread=new MyThread();
            thread.start();
            thread.interrupt();
            System.out.println(thread.getClass());
            System.out.println("第一次调用thread.isInterrupted()："+thread.isInterrupted());
            System.out.println("第二次调用thread.isInterrupted()："+thread.isInterrupted());
            //测试interrupted（）函数
            System.out.println(thread.getClass());
            System.out.println("第一次调用thread.interrupted()："+thread.interrupted());
            System.out.println("第二次调用thread.interrupted()："+thread.interrupted());
            System.out.println("thread是否存活："+thread.isAlive());

            System.out.println("thread是否存活："+thread.isAlive());
            System.out.println("thread是否存活："+thread.isAlive());

            System.out.println("dev：--"+thread.isAlive());

        }
    }
}
