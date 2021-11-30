package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Hardware
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:03
 */

public class Hardware extends Maintainer {

    @Override
    public void work() {
        System.out.println("员工号为"+getId()+"的 "+getName()+"员工，正在修复打印机");

    }

    public Hardware() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Hardware(String id,String name){
        super(id,name);
    }

}