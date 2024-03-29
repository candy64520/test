package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: ACourse
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:20
 */
public abstract class ACourse {

    protected final void makeCourse() {
        this.makePPT();
        this.makeVideo();
        if (needWriteArticle()) {
            this.writeArticle();
        }
        this.packageCourse();
    }

    final void makePPT() {
        System.out.println("1. 制作PPT");
    }

    final void makeVideo() {
        System.out.println("2. 制作视频");
    }

    final void writeArticle() {
        System.out.println("3. 编写课程笔记");
    }

    //钩子方法
    protected boolean needWriteArticle() {
        return false;
    }

    abstract void packageCourse();
}