package com.test.test3;

import java.util.Observer;

/**
 * @Package: com.test.test3
 * @ClassName: Subject
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/30 0:39
 */
public interface Subject {
    // 添加订阅关系
    void attach(Observer observer);
    // 移除订阅关系
    void detach(Observer observer);
    // 通知订阅者
    void notifyObservers(String message);
}
