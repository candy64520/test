package com.test.day.day0322.day2021;

import lombok.Data;

/**
 * @Package: com.test.day2021
 * @ClassName: Student
 * @Author: 86150
 * @Description:
 * @Date: 2021/6/3 21:17
 */
@Data
public class Student {

    private String name;
    private int age;
     private String address;
     public Student(String name,int age,String address){
                 this.name = name;
                 this.age = age;
                 this.address = address;
             }
}
