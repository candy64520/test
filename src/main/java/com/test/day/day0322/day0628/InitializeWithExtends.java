package com.test.day.day0322.day0628;

/**
 * @Package: com.test.day0628
 * @ClassName: InitializeWithExtends
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/28 22:57
 */
class XD {
    XD(int maker) {
        System.out.println("XD(" + maker +")");
    }
}

class Father {
    Father() {
        System.out.println("Father()");
    }
    static XD xd = new XD(1);
    XD xd1 = new XD(2);
}

class Son extends Father {
    Son() {
        System.out.println("Son()");
    }
    static XD xd = new XD(3);
    XD xd1 = new XD(4);
    static void f() { System.out.println("f()"); }
}


public class InitializeWithExtends {
    public static void main(String[] args) {
        new Son();
        System.out.println("---");
       // new Son();
    }
}