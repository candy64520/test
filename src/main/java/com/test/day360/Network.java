package com.test.day360;

/**
 * @Package: com.test.day360
 * @ClassName: Network
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/25 23:03
 */

public class Network extends Maintainer {

    @Override
    public void work() {
        System.out.println("员工号为"+getId()+"的 "+getName()+"员工，正在检查网络是否畅通");

    }

    public Network() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Network(String id,String name){
        super(id,name);
    }
}