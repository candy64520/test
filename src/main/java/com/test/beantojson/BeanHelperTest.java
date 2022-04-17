package com.test.beantojson;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//单元测试
public class BeanHelperTest {

    @Test
    public void convertCompare() {
        List<TestVo> mockList = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            TestVo vo = new TestVo();
            vo.setAge(Math.round(0));
            vo.setBirthday("999");
            vo.setName("898989898");
            mockList.add(vo);
        }
        convertList(mockList);
        testCopyListProperties(mockList);
        testCopyListProperties2(mockList);
    }


    public void convertList(List<TestVo> mockList) {
        long startTime = System.currentTimeMillis();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        BeanHelper.convertList(mockList, TestVo.class);

        stopWatch.stop();
        long endTime = System.currentTimeMillis();
        System.out.printf("10万数据fastJson JSON.parseArray(JSON.toJSONString(obj), clazz)序列化再返序列化执行时长：%d 毫秒.%n", (endTime - startTime) + "ms");
    }


    public void testCopyListProperties(List<TestVo> mockList) {
        long startTime = System.currentTimeMillis();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        BeanHelper.copyListProperties(mockList, TestVo.class);
        stopWatch.stop();
        long endTime = System.currentTimeMillis();
        System.out.printf("10万数据BeanHelper.copyListProperties执行时长：%d 毫秒.%n", (endTime - startTime) + "ms");
    }


    public void testCopyListProperties2(List<TestVo> mockList) {
        long startTime = System.currentTimeMillis();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<TestVo> TestVos = BeanHelper.copyListProperties(mockList, TestVo::new);
        stopWatch.stop();
        long endTime = System.currentTimeMillis();
        System.out.printf("10万数据BeanHelper.copyListProperties Supplier方式执行时长：%d 毫秒.%n", (endTime - startTime) + "ms");
    }
}
