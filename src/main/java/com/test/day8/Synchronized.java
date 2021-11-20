package com.test.day8;

/**
 * @Package: com.test.day8
 * @ClassName: Synchronized
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/12 20:55
 */


/**
 * @author 卷心菜
 * @version 1.0
 * @date 2021/10/24 9:12
 * @Description
 * @motto 路漫漫其修远兮
 */
public class Synchronized {

    private Integer synchronizedLock;

    public static void main(String[] args) {
        Synchronized st = new Synchronized();
        Synchronized st2 = new Synchronized();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入");
   //         st.test1();
           st.test2();
//            st.test3();
//            st.test4();
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " test 准备进入");
  //          st2.test1();
           st2.test2();
//            st2.test3();
//            st2.test4();
        }).start();
    }


    /**
     *修饰普通方法,锁住的是当前实例对象
     *同一个实例调用会阻塞
     * 不同实例调用不会阻塞
     */
    private synchronized void test1(){

        try {
            System.out.println(Thread.currentThread().getName() + " test1 进入了同步方法");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " test1 休眠结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步代码块传参this，锁住的是当前实例对象
     */
    private void test2(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName() + " test2 进入了同步方法");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " test2 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步代码块传参变量对象，锁住的是变量对象
     */
    private void test3(){
        synchronized (synchronizedLock){
            try {
                System.out.println(Thread.currentThread().getName() + " test3 进入了同步方法");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " test3 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步代码块传参class对象，全局锁
     */
    private void test4(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName() + " test4 进入了同步方法");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " test4 休眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
