package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Test2
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:21
 */
public class Test2{
    public static void main(String[] args) {
        System.out.println("Java课程start---");
        ACourse javaCourse = new JavaCourse();
        javaCourse.makeCourse();
        System.out.println("Java课程end---\n");


        System.out.println("前端课程start---");
        ACourse feCourse = new FECourse(false);
        feCourse.makeCourse();
        System.out.println("前端课程end---");
    }
}
