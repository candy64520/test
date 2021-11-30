package com.test.day6;


/**
 * @Package: com.test.day6
 * @ClassName: Subject
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/9 10:58
 */
public interface Subject {
    // 添加订阅关系
    void attach(Observer observer);
    // 移除订阅关系
    void detach(Observer observer);
    // 通知订阅者
    void notifyObservers(String message);
}
