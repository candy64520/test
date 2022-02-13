package com.test.thread3;

/**
 * @Package: com.test.thread3
 * @ClassName: Nothreading
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/16 0:38
 */
public class Nothreading {

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        int sum_i = 0;
        int sum_j = 0;
        int sum_k = 0;
        for(int i = 0; i < 10000; i++)
        {
            sum_i += 1;
            //增加程序运行时间， 后面同理
            for(int a = 0 ; a < 100 ; a ++)
            {
                String s = "To cost some time";
                String[] ss = s.split(" ");
            }
        }
        for(int j = 0; j < 10000; j++)
        {
            sum_j += 2;
            for(int a = 0 ; a < 100 ; a ++)
            {
                String s = "To cost some time";
                String[] ss = s.split(" ");
            }
        }
        for(int k = 0; k < 10000; k++)
        {
            sum_k += 3;
            for(int a = 0 ; a < 100 ; a ++)
            {
                String s = "To cost some time";
                String[] ss = s.split(" ");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(sum_i + "\t" + sum_j + "\t" + sum_k);
        System.out.println("run time:"+(endTime-startTime)+"ms");
    }
}
