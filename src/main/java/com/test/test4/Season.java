package com.test.test4;

/**
 * @Package: com.test.test4
 * @ClassName: Season
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/30 15:13
 */
public enum Season {
    SPRING(1, "spring"), SUMMER(2, "summer"), AUTUMN(3, "autumn"), WINTER(4, "winter");

    private int value;
    private String lab;

      Season(int value, String lab){
        this.value = value;
        this.lab = lab;
    }
}
