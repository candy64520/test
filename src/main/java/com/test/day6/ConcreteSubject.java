package com.test.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.test.day6
 * @ClassName: ConcreteSubject
 * @Author: 86150
 * @Description: 先创建一个主题定义，定义添加删除关系以及通知订阅者
 *          构建一个容器来维护订阅关系，支持添加删除关系，以及通知订阅者
 * @Date: 2021/11/9 10:59
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
            observer.update(message);
        }
    }
}

