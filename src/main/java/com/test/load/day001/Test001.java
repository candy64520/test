package com.test.load.day001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Package: com.test.load.day001
 * @ClassName: Test001
 * @Author: 86150
 * @Description:
 * @Date: 2021/9/25 21:48
 */
public class Test001 {
    static ThreadLocal<User> threadLocalUser = new ThreadLocal<>();

    public static void main(String[] args) {
        try {

            String s1 = "Programming";
            String s2 = new String("Programming");
            String s3 = "Program";
            String s4 = "ming";
            String s5 = "Program" + "ming";
            String s6 = s3 + s4;
            System.out.println(s1 == s2);
            System.out.println(s1 == s5);
            System.out.println(s1 == s6);
            System.out.println(s1 == s6.intern());
            System.out.println(s2 == s2.intern());


            User user = new User();
            user.setId(2);
            user.setName("name");
            System.out.println(user.toString());
            threadLocalUser.set(user);
            System.out.println(user.toString());
            step1();
            System.out.println(user.toString());
            step2();
            System.out.println(user.toString());

            LinkedList list = new LinkedList();
            for (int i=0;i<list.size();i++){

            }
        } finally {
            threadLocalUser.remove();
        }
    }


    static void step1() {
        User u = threadLocalUser.get();
//        log();
        u.setId(222);
    }

    static void log() {
        User u = threadLocalUser.get();
        u.setName("candy");
    }

    static void step2() {
        User u = threadLocalUser.get();
        u.setName("candy5");
    }

}
