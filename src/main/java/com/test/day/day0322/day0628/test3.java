package com.test.day.day0322.day0628;

import org.junit.Test;

import java.io.Serializable;

/**
 * @Package: com.test.day0628
 * @ClassName: test3
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/28 23:00
 *
 * 在一般传值调用的机制中只能把实参传送给形参，而不能把形参的值反向地传送给实参。
 * 因此在函数调用过程中，形参值发生改变，而实参中的值不会变化。
 * 而在引用调用的机制当中是将实参引用的地址传递给了形参，所以任何发生在形参上的改变实际上也发生在实参变量上。
 */
public class test3 implements Serializable {
    public static void main(String[] args) {
        int i=1;
        String str = "hello";
        Integer num = 20;
        int[] arr ={1,2,3,4};
        MyData my = new MyData();

        change(i,str,num,arr,my);

        System.out.println(" i :"+i);
        System.out.println(" str "+str);
        System.out.println(" num :"+num);
        System.out.println(" arr :"+arr);
        System.out.println(" my :"+my.a);
    }

    public static void change(int j,String s,Integer n,int[] a,MyData m){
        j +=1;
        s +=" world";
        n +=1;
        a[0] +=12;
        m.a +=3;
    }

    @Test
    public  void test2()
    {
        System.out.println(test());
    }
    public  int test()
    {
        try
        {
            System.out.println("try语句块");

//            throw new Exception( );
            return 1;
        }
        catch(Exception e)
        {
            System.out.println("catch语句块");
            return 2;
//            e.printStackTrace( );
        }
        finally
        {
            System.out.println("finally语句块");
            return 3;
        } // try-catch-finally结构结束
    } // 方法main结束

/*运行流程：
1.try语句块捕捉throw的异常
2.跳转到相关的catch语句块
3.最后执行finally语句块的内容
*/

}
class MyData{
    int a =10;
}
