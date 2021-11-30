package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Employee
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 22:52
 */
public abstract class Employee {   //父类，描述雇员共有信息（抽象类）

    private String name;

    public Employee(){}
    public Employee(String name) {
        this.name=name;
        System.out.println("name---"+name);
        System.out.println("******************");
    }
    public String getName() {
        return name;
    }
    public abstract double ComputeSalary() ;  //抽象方法，计算雇员的工资，子类要重写
}

class Manager extends Employee{   //Manager类，计算经理工资

    private double monthwage;  //经理固定月工资

    public Manager() {}
    public Manager(String name,double monthwage) {
        super(name);
        this.monthwage=monthwage;
    }
    public double ComputeSalary() {
        return monthwage;
    }
}
class Salesman extends Employee{  //计算销售人员工资

    private double baseSalary;  //基本工资
    private double commision;   //销售每件的提成
    private int qualtities;     //销售件数

    public Salesman() {}
    public Salesman(String name,double baseSalary,double commission,int qualitities) {
        super(name);
        this.baseSalary=baseSalary;
        this.commision=commission;
        this.qualtities=qualitities;
    }
    public double ComputeSalary() {
        return baseSalary+commision*qualtities;
    }
}

class Worker extends Employee{    //计算一般工人工资

    private double dailySalary;   //每天工资
    private int days;    //每月工作天数
    public Worker() {}
    public Worker(String name,double dailySalary,int days) {
        super(name);
        this.dailySalary=dailySalary;
        this.days=days;
    }
    public double ComputeSalary() {
        return dailySalary*days;
    }
}


//

