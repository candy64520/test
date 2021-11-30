package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: JavaCourse
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:20
 */
public class JavaCourse extends ACourse {
    @Override
    void packageCourse() {
        System.out.println("4. 提供Java课程源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}