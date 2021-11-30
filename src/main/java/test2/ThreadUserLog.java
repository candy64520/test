package test2;

import org.springframework.stereotype.Component;

/**
 * @Package: com.test.test
 * @ClassName: ThreadUserLog
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/16 20:46
 */
@Component
public class ThreadUserLog {

    //存储线程对应的用户名日志信息
    private static ThreadLocal<LogComponent> userRecode = new ThreadLocal<LogComponent>();

    /****
     * 添加用户信息记录
     */
    public void add(LogComponent logComponent){
        userRecode.set(logComponent);
    }

    /***
     * 记录方法名和参数
     * @param args
     */
    public String reload(String... args){
        //获取对象
        LogComponent logComponent = userRecode.get();
        //设置数据
        logComponent.supplementLogContent(args);
        return logComponent.toString();
    }

    /****
     * 获取LogComponent
     */
    public LogComponent get(){
        return userRecode.get();
    }

    /****
     * 移除
     */
    public void remove(){
        userRecode.remove();
    }
}
