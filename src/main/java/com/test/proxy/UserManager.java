package com.test.proxy;

/**
 * @Package: com.test.proxy
 * @ClassName: UserManager
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/12 16:59
 */
public interface UserManager {
    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    void delUser(String userName);
}
