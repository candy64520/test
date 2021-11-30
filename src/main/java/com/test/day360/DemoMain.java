package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: DemoMain
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 22:46
 */
public class DemoMain {

    public static void main(String[] args) {
        GoldenDog goldenDog = new GoldenDog();
        goldenDog.eat();
        goldenDog.sleep();
        // goldenDog.eat();
        System.out.println("================");
        Taidi taidi = new Taidi();
        taidi.eat();
        taidi.sleep();
    }
}

