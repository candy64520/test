package com.test.day.day0322.day0628;

/**
 * @Package: com.test.day0628
 * @ClassName: PartyMember
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/28 22:44
 */

public class PartyMember {

    /**
     * 非静态变量（实例属性）
     */
    int apple = 8;
    int banana = 9;

    /**
     * 构造方法
     */
    public PartyMember(int apple, int banana) {
        this.apple = apple;
        this.banana = banana;
        System.out.println("构造方法中：");
        System.out.println(this.apple + " " + this.banana);
    }

    /**
     * 非静态代码块
     */
    {
        this.apple--;
        this.banana--;
        System.out.println("非静态代码块中：");
        System.out.println(this.apple + " " + this.banana);
    }

    /**
     * main方法
     */
    public static void main(String[] args) {
        new PartyMember(1, 2);
    }
}