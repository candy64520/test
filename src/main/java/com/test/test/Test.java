package com.test.test;




import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Package: com.test.test
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/13 13:59
 */
public class Test {

    /** 订单号生成(NEW) **/
    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
    public static String generateOrderNo(){
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if(SEQ.intValue()>9990){
            SEQ.getAndSet(1000);
        }
        return  dataTime.format(DF_FMT_PREFIX)+SEQ.getAndIncrement();
    }


    public static void main(String[] args) {
        List orderNos = Collections.synchronizedList(new ArrayList());
        IntStream.range(0,8000).parallel().forEach(i->{
            orderNos.add(generateOrderNo());
        });
        List filterOrderNos = (List) orderNos.stream().distinct().collect(Collectors.toList());
        System.out.println("生成订单数："+orderNos.size());
        System.out.println("过滤重复后订单数："+filterOrderNos.size());
        System.out.println("重复订单数："+(orderNos.size()-filterOrderNos.size()));
    }/**
     测试结果：
     生成订单数：8000
     过滤重复后订单数：8000
     重复订单数：0
     **/
}
