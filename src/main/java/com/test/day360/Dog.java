package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Son
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 22:39
 */
public abstract class Dog extends Animal {
    Dog() {
        System.out.println("父亲构造方法！dog");
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

}