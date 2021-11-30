package com.test.test3;

/**
 * @Package: com.test.test3
 * @ClassName: FriendOneObserver
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/30 0:41
 */
public class FriendOneObserver implements Observer {

    @Override
    public void update(String message) {
        // 模拟处理业务逻辑
        System.out.println("FriendOne 知道了你发动态了" + message);
    }
}
