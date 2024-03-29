package com.test.day6;

/**
 * @Package: com.test.day6
 * @ClassName: test
 * @Author: 86150
 * @Description: 最后就是创建具体的观察者类，实现观察者接口的update方法，处理本身的业务逻辑
 * @Date: 2021/11/9 11:00
 */
public class test {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        // 这里假设是添加好友
        subject.attach(new FriendOneObserver());
        FriendTwoObserver twoObserver = new FriendTwoObserver();
        subject.attach(twoObserver);

        // 发送朋友圈动态
        subject.notifyObservers("第一个朋友圈消息");
        // 输出结果： FriendOne 知道了你发动态了第一个朋友圈消息
        //          FriendTwo 知道了你发动态了第一个朋友圈消息

        // 这里发现 twoObserver 是个推荐卖茶叶的，删除好友
        subject.detach(twoObserver);
        subject.notifyObservers("第二个朋友圈消息");
        // 输出结果：FriendOne 知道了你发动态了第二个朋友圈消息
    }
}
