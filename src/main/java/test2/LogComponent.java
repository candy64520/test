package test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Package: com.test.test
 * @ClassName: LogComponent
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/16 20:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class LogComponent {
    /**********************************************************
     * 同一个线程中，记录日志时，username、sex、role相同
     **********************************************************/
    //用户名字
    private String username;
    //用户性别
    private String sex;
    //用户角色
    private String role;

    /**********************************************************
     * 同一个线程中，记录日志时，每次访问的不同方法和参数不一样
     **********************************************************/
    //操作方法
    private String methodName;
    //信息
    private String message;

    /**********************************************************
     * 业务操作,补充和完善methodName，args参数
     **********************************************************/
    abstract void supplementLogContent(String... args);

    /****
     * 对username、sex、role赋值[这些是同一个线程中不变的数据]
     */
    public LogComponent(String username, String sex, String role) {
        this.username = username;
        this.sex = sex;
        this.role = role;
    }
}
