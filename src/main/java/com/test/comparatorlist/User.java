package com.test.comparatorlist;

import lombok.Data;

/**
 * @Package: com.test.comparatorlist
 * @ClassName: User
 * @Author: 86150
 * @Description:
 * @Date: 2021/5/16 13:21
 */
@Data
public class User {
    private int age;

    private int salary;

    private int sales;


    public User(int age,int salary,int sales)
    {
        super();
        this.age = age;
        this.salary = salary;
        this.sales = sales;
    }


    @Override
    public String toString()
    {
        return "User [age=" + age + ", salary=" + salary + ", sales=" + sales + "]";
    }


}
