package com.test.proxy;

/**
 * @Package: com.test.proxy
 * @ClassName: UserDaoImpl
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/12 19:48
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("持久层：用户保存000000");
    }
}
