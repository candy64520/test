package com.test.proxy;

/**
 * @Package: com.test.proxy
 * @ClassName: UserManagerImpl
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/12 16:59
 */
public class UserManagerImpl implements UserManager{
    //重写新增用户方法
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: "+userName+" password: "+password);
    }
    //重写删除用户方法
    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: "+userName);
    }
}
