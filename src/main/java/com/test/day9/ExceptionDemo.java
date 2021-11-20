package com.test.day9;

/**
 * @Package: com.test.day9
 * @ClassName: ExceptionDemo
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/14 17:02
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("调用方法之前");
        try {
            method();// 编译时期异常抛出必须处理
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("调用方法1后在调用方法二");
        method2();
    }

    public static void method2() throws RuntimeException{
        int a = 10;
        int b = 0;
        System.out.println("a/b="+a/b);//运行时期异常可以不用处理，如果处理为抛出异常throws,那么调用者也无需必须处理异常
    }

    public static void method() throws ParseException {
        String string = "2015-05-30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//会逐步匹配string格式，不对就抛异常
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//如果string只有2015-05-30，没有后面的，那么会跑异常，因为这个sdf2无法匹配HH:mm:ss
        Date date = sdf.parse(string);
        System.out.println("日期格式化：" + date);
    }

}