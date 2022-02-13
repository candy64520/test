package com.test.day2022;

/**
 * @Package: com.test.day2022
 * @ClassName: Student
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/7 0:20
 */
import lombok.Data;

import java.math.BigDecimal;
@Data
public class Student {
    private Integer id;
    private String sex;
    private Integer age;
    private BigDecimal score;
    private  Use Use;


    public Student(Integer id, String sex, Integer age, BigDecimal score, com.test.day2022.Use use) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.score = score;
        Use = use;
    }

}