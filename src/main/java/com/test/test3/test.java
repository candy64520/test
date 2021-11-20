package com.test.test3;

/**
 * @Package: com.test.test3
 * @ClassName: test
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/30 0:41
 */
public class test {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        // 这里假设是添加好友
        subject.attach((java.util.Observer) new FriendOneObserver());
        FriendOneObserver twoObserver = new FriendOneObserver();
        subject.attach((java.util.Observer) twoObserver);

        // 发送朋友圈动态
        subject.notifyObservers("第一个朋友圈消息");
        // 输出结果： FriendOne 知道了你发动态了第一个朋友圈消息
        //          FriendTwo 知道了你发动态了第一个朋友圈消息

        // 这里发现 twoObserver 是个推荐卖茶叶的，删除好友
        subject.detach((java.util.Observer) twoObserver);
        subject.notifyObservers("第二个朋友圈消息");
        // 输出结果：FriendOne 知道了你发动态了第二个朋友圈消息
    }
}
