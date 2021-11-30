package com.test.day6;

/**
 * @Package: com.test.day6
 * @ClassName: Observer
 * @Author: 86150
 * @Description: 订阅者
 * @Date: 2021/11/9 10 :59
 */
public interface Observer {
    // 处理业务逻辑
    void update(String message);
}
