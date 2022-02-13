package com.test.listSplitUtil;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import com.test.day2022.CollectorsUtil;
import com.test.day2022.Student;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分批处理集合
 */
public class testHandler {

    @Test
    public  void testHandler() {
        //业务数据
        List<BigDecimal> dataList=new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            dataList.add(new BigDecimal(i));
        }
        int total = dataList.size();
        // 每次分批处理个数
        int num=500;
        long startTime = System.currentTimeMillis();
        List<BigDecimal> result=new ArrayList<>();
        // 数据量大于500 进行分批，小于等于则不用分批执行
        if (total > 500) {
            try {
               Stream.iterate(0, i -> i + 1).limit(dataList.size() / num + 1).parallel().map(i -> {
                    //获取每一批的数据
                    List<BigDecimal> perList = dataList.parallelStream().skip(i * num)
                            .limit(num)
                            .collect(Collectors.toList());
                    //业务处理
                   result.add(queryThisData(perList,i));
                    return  result;
                }).filter(o -> Objects.nonNull(o))
                        .flatMap(Collection::parallelStream)
                        .collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            result.add(queryThisData(dataList, total));
        }


        System.out.println("result--》"+ JSONObject.toJSONString(result));
        long endTime = System.currentTimeMillis();
        System.out.println("并发批量处理耗时："+(endTime-startTime)+" 数据总数："+result.size());

        //不并发分批
        List<BigDecimal> result2=new ArrayList<>();
        List<List<BigDecimal>> parList=new ArrayList<>();
        int size = dataList.size() % num == 0 ? (dataList.size() / num) : (dataList.size() / num + 1);
        for (int i = 0; i < size ; i++) {
            List<BigDecimal> list=new ArrayList<>();
            for (int j=i*num;j<num*(i+1);j++){
                list.add(dataList.get(j));
            }
            parList.add(list);
        }
        for (int i = 0; i < parList.size(); i++) {
            result2.add(queryThisData(parList.get(i),i));
        }
        System.out.println("不并发批量处理耗时："+(System.currentTimeMillis()-endTime)+" 数据总数："+result2.size());
    }

    private static BigDecimal queryThisData(List<BigDecimal> perList,int i) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Double re = perList.stream().mapToDouble(x->Double.valueOf(String.valueOf(x))).sum();

        return new BigDecimal(re);
    }


}
