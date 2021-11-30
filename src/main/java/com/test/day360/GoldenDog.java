package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: GoldenDog
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 22:45
 */
public class GoldenDog extends Dog{
    GoldenDog(){
        System.out.println("子构造方法！金毛");
    }

    @Override
    public void sleep() {
        System.out.println("金毛睡觉，呼呼呼");
    }

    @Override
    public void eat() {
        System.out.println("金毛小可爱---狗吃骨头");
    }
}
