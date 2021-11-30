package com.test.day.day0322.day0523;

/**
 * @Package: com.test.day0523
 * @ClassName: test
 * @Author: 86150
 * @Description: 11
 * @Date: 2020/5/23 15:26
 */
public class test {
    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        volatileExample.writer();
        System.out.println(volatileExample.x);

        boolean aa =true;
        double a = 9.9;
    }
    // 以下代码来源于【参考 1】
    static class VolatileExample {
        int x = 0;
        volatile boolean v = false;
        public void writer() {
            x = 42;
            v = true;
        }
        public void reader() {
            if (v == true) {
                // 这里 x 会是多少呢？
            }
        }
    }
}
