package com.test.day360;

import lombok.Data;

/**
 * @Package: com.test.day360
 * @ClassName: Employee11
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:01
 */

@Data
public abstract class Employee1 {

    private String id;
    private String name;

    public abstract void work();

    public Employee1() {
        super();//访问父类对象的空参方法
    }

    public Employee1(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }




}