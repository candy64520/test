package com.test.load;

import lombok.Data;

/**
 * @Package: com.test.load
 * @ClassName: User
 * @Author: 86150
 * @Description:
 * @Date: 2021/8/10 13:59
 */
@Data
public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //User类需要重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        OOMTest.list.add(this);
        System.out.println("关闭资源，userid=" + id + "即将被回收");
    }
}
