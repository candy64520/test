package com.test.day8;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Package: com.test.day8
 * @ClassName: MyTimerTask
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/12 16:00
 */
public class MyTimerTask {
    public static void main(String[] args) {
        // 定义一个任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("运行定时任务："+ new Date());
            }
        };
        // 计时器
        Timer timer = new Timer();
        // 添加执行任务（延迟1s执行，每三秒执行一次）
        timer.schedule(timerTask,1000,3000);
    }
}
