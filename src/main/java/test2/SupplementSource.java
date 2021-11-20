package test2;

import test2.LogComponent;

/**
 * @Package: com.test.test
 * @ClassName: SupplementSource
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/16 20:46
 */
public class SupplementSource extends LogComponent {
    /****
     * 填充参数
     * @param username
     */
    public SupplementSource(String username, String sex, String role) {
        super(username, sex, role);
    }
    /****
     * 业务逻辑，完善不同方法的日志记录
     * @param args 长度为2，第1个是方法名字，第2个是方日志信息
     */
    @Override
    void supplementLogContent(String... args) {
        super.setMethodName(args[0]);
        super.setMessage(args[1]);
    }
}
