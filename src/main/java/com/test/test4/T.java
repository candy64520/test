package com.test.test4;

/**
 * @Package: com.test.test4
 * @ClassName: T
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/7 15:55
 */
import java.util.concurrent.TimeUnit;

class T
{
    static class Data{
        //       volatile   int number =0;
        int number =0;
        public void add()
        {
            this.number = number +1;
        }
    }
    // 启动两个线程，一个work线程，一个main线程，work线程修改number值后，查看main线程的number
    private static void testVolatile() {
        Data myData = new Data();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(2);
                myData.add();
                System.out.println(Thread.currentThread().getName()+"\t update number value :"+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "workThread").start();

        //第2个线程，main线程
        while (myData.number == 0){
            //main线程还在找0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
        System.out.println(Thread.currentThread().getName()+"\t mission is over，main get number is:"+myData.number);
    }
    public static void main(String[] args) {
        testVolatile();
    }
}