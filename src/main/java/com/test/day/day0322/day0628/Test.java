package com.test.day.day0322.day0628;

/**
 * @Package: com.test.day0628
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/28 22:52
 */
class A {
    A(int maker) {
        System.out.println("A(" + maker + ")");
    }
}

class Test {
    static A a1 = new A(1);
    A a2 = new A(2);
    {
        System.out.println("非静态的代码块");
    }
    A a3 = new A(3);
    static {
        System.out.println("静态块");
        A a4 = new A(4);
    }


    static void f() {System.out.println("f()");}
    Test() {
        System.out.println("Test()");
    }
    static A a5 = new A(5);

    static A a8 = new A(888);
}

 class Initialize {
    public static void main(String[] args) {
        Test.f();
        System.out.println("----");
        new Test();
    }
}