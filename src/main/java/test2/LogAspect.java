/*
package test2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

*/
/**
 * @Package: test2
 * @ClassName: LogAspect
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/16 20:49
 *//*

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private ThreadUserLog threadUserLog;

    */
/***
     * 记录日志
     *//*

    @SneakyThrows
    @Before("execution(* com.learn.shop.service.impl.*.*(..))")
    public void logRecode(JoinPoint joinPoint){
        //获取方法名字和参数
        String methodName = joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName();
        //记录日志
        log.info(threadUserLog.reload(methodName,args(joinPoint.getArgs())));
    }

    */
/****
     * 参数获取
     *//*

    public String args(Object[] args){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <args.length ; i++) {
            buffer.append("  args("+i+"):"+args[i].toString());
        }
        return buffer.toString();
    }
}
*/
