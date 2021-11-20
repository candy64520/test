package com.test.day.day0322.day0630;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.List;

/**
 * @Package: com.test.day0630
 * @ClassName: test
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/30 18:32
 */
public class test {
    public static void main(String[] args) {
        // 通过匿名类来创建一个新线程，执行任务A
        new Thread(() -> {
            System.out.println("正在异步处理 taskA 中...");
            // do things
        }).start();

        // 主线程继续做其他事情
        System.out.println("do other things...");


        //使用方法引用，引用的是类的静态方法
        Object[] pArr;
        Person p1 = new Person("xiao","12");
        Person p2 = new Person("xixi","13");
        List<Person> list = Arrays.asList(p1,p2);


        System.out.println("CPU核数 "+Runtime.getRuntime().availableProcessors());
    }




}
