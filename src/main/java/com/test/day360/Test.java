package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:03
 */

public class Test {

    public static void main(String[] args) {
        JavaEE javaEE = new JavaEE();
        javaEE.setId("t001");
        javaEE.setName("小强");
        javaEE.work();

        JavaEE javaEE2 = new JavaEE("t002","小明");
        javaEE2.work();

    }

}