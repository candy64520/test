package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: FECourse
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:20
 */
public class FECourse extends ACourse {
    private boolean needWriteArticleFlag = false;
    @Override
    void packageCourse() {
        System.out.println("4.1 提供课程的前端代码");
        System.out.println("4.2 提供课程的图片等多媒体素材");
    }

    public FECourse(boolean needWriteArticleFlag) {
        this.needWriteArticleFlag = needWriteArticleFlag;
    }

    @Override
    protected boolean needWriteArticle() {
        return this.needWriteArticleFlag;
    }
}