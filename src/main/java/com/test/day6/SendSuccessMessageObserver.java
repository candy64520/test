package com.test.day6;

/**
 * @Package: com.test.day6
 * @ClassName: SendSuccessMessageObserver
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/9 13:41
 */
public class SendSuccessMessageObserver implements Observer {

    @Override
    public void update(String message) {
        // 处理业务逻辑
        System.out.println("注册成功");
    }

    public static void main(String[] args) {
        // 假设用户注册成功直接通知观察者，改干自己的事情了
        ConcreteSubject subject = buildSubject();
        subject.notifyObservers("");

        ThreadLocal local = new ThreadLocal();
    }

    private static ConcreteSubject buildSubject() {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new SendSuccessMessageObserver());
        subject.attach(new SendNewPersonCouponObserver());
        return subject;
    }
}
