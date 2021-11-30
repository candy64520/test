package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Employees
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 22:52
 */
public class Employees {

    public static void main(String aegs[]) {
        Manager manager_1=new Manager("张三",6000);
        Salesman salesman_1=new Salesman("李四",2500,30,90);
        Worker worker_1=new Worker("王五",200,24);

        System.out.println("张三这个月的工资为"+manager_1.ComputeSalary()+"元");
        System.out.println("李四这个月的工资为"+salesman_1.ComputeSalary()+"元");
        System.out.println("王五这个月的工资为"+worker_1.ComputeSalary()+"元");
    }
}
