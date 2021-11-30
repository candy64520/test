package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Parent
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 22:29
 */
public abstract class Animal {
    Animal() {
        System.out.println("父亲构造方法animal");
    }

     abstract void sleep();

     abstract void eat();
}
