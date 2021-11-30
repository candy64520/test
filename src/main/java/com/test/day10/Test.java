package com.test.day10;

/**
 * @Package: com.test.day10
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/20 1:03
 */
public class Test {

    public static void main(String[] args) {
        B testb = new B();
    }
}
class A {
    public B b;
    public A() {
        b = new B();
    }

    public void printB() {
        System.out.println("Ab");
        b.printA();
    }

    public void printA() {
        System.out.println("AA");
    }

}

class B {
    public A a;
    public B() {
        a = new A();
    }

    public void printB() {
        System.out.println("BB");
        a.printA();
    }

    public void printA() {
        a.printA();
    }

}
