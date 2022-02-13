package com.test.thread3;

import com.test.test.AA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.test.thread3
 * @ClassName: Count
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/16 0:40
 */
public class Threethreading_save {


    public static void main(String[] args) throws InterruptedException
    {
        long startTime = System.currentTimeMillis();
        Count_i ci = new Count_i();
        Count_j cj = new Count_j();
        Count_k ck = new Count_k();
        Mul_thread_i aa = new Mul_thread_i(ci);
        Mul_thread_j bb = new Mul_thread_j(cj);
        Mul_thread_k cc = new Mul_thread_k(ck);

        aa.start();
        bb.start();
        cc.start();
        aa.join();
        bb.join();
        cc.join();

        List<Object> list = new ArrayList<>();
        list.add(ci);
        list.add(cj);
        list.add(ck);

        System.out.println(ci.sum_i);
        System.out.println(cj.sum_j);
        System.out.println(ck.sum_k);
        long endTime = System.currentTimeMillis();
        System.out.println("run time:"+(endTime-startTime)+"ms");
    }


    static class Count_i
    {
        public int sum_i = 0;
        public synchronized void count()
        {
            for(int i = 0 ; i < 10000; i++)
            {
                sum_i += 1;
                /* 增加运行时间 后面同理*/
                for(int a = 0 ; a < 100; a ++)
                {
                    String s = "To cost some time";
                    String[] ss = s.split(" ");
                }
            }
        }
    }

    static class Count_j
    {
        public int sum_j = 0;
        public synchronized void count()
        {
            for(int j = 0 ; j < 10000; j++)
            {
                sum_j += 2;
                for(int a = 0 ; a < 100; a ++)
                {
                    String s = "To cost some time";
                    String[] ss = s.split(" ");
                }
            }
        }
    }

    static class Count_k
    {
        public int sum_k = 0;
        public synchronized void count()
        {
            for(int k = 0 ; k < 10000; k++)
            {
                sum_k += 3;
                for(int a = 0 ; a < 100; a ++)
                {
                    String s = "To cost some time";
                    String[] ss = s.split(" ");
                }
            }
        }
    }

    static class Mul_thread_i extends Thread
    {
        public Count_i c_i;
        public Mul_thread_i(Count_i acc)
        {
            this.c_i = acc;
        }
        public void run()
        {
            c_i.count();
        }
    }

    static class Mul_thread_j extends Thread
    {
        public Count_j c_j;
        public Mul_thread_j(Count_j acc)
        {
            this.c_j = acc;
        }
        public void run()
        {
            c_j.count();
        }
    }

    static class Mul_thread_k extends Thread
    {
        public Count_k c_k;
        public Mul_thread_k(Count_k acc)
        {
            this.c_k = acc;
        }
        public void run()
        {
            c_k.count();
        }
    }



}
