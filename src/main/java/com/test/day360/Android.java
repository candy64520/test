package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Android
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:02
 */

public class Android extends Developer {

    @Override
    public void work() {
        System.out.println("员工号为"+getId()+"的 "+getName()+"员工,正在研发淘宝手机客户端软件");

    }

    public Android() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Android(String id,String name){
        super(id,name);
    }

}
