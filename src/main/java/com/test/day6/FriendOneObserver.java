package com.test.day6;

/**
 * @Package: com.test.day6
 * @ClassName: FriendOneObserver
 * @Author: 86150
 * @Description: 创建一个观察者接口，方便我们管理
 * @Date: 2021/11/9 11:00
 */
public class FriendOneObserver implements Observer {

    @Override
    public void update(String message) {
        // 模拟处理业务逻辑
        System.out.println("FriendOne 知道了你发动态了" + message);
    }
}
