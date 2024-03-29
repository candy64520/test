package com.test.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @Package: com.test.test3
 * @ClassName: ConcreteSubject
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/30 0:40
 */
public class ConcreteSubject implements Subject {

    // 订阅者容器
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        // 添加订阅关系
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        // 移除订阅关系
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        // 通知订阅者们
        for (Observer observer : observers) {
//            observer.update(message);
        }
    }
}
