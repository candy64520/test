package com.test.day2022;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package: com.test.day2022
 * @ClassName: Test2
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/18 0:05
 */
public class Test2 {

    public static void main(String[] args) {

        Set<Map<String,BigDecimal>> set = getdata();
        System.out.println(JSONObject.toJSON(set));


        Map<String, Double> result = set.stream()
                .flatMap(m -> m.entrySet().stream().filter(e -> e.getValue() != null))
                .collect(Collectors.groupingBy(e -> e.getKey(),
                        Collectors.averagingDouble(e -> Double.valueOf(String.valueOf(e.getValue())))));

        Set<Double> list = result.values().stream().filter(x->x !=null).collect(Collectors.toSet());
        System.out.println("----按照性别求分数平均值----"+JSONObject.toJSONString(result));
        Double dd = list.stream().mapToDouble(Double::doubleValue).average().orElse(Double.valueOf(0));
        System.out.println("----按照性别求分数平均值----"+new BigDecimal(dd));

    }

    public static  Set<Map<String,BigDecimal>> getdata(){
        Set<Map<String, BigDecimal>> setlist = new HashSet<>();
        Map<String,BigDecimal> map = new HashMap<>();
        map.put("类型1",new BigDecimal(1000));
        setlist.add(map);

        map = new HashMap<>();
        map.put("类型2",new BigDecimal(2000));
        setlist.add(map);

        map = new HashMap<>();
        map.put("类型3",new BigDecimal(3000));
        setlist.add(map);

        map = new HashMap<>();
        map.put("类型1",new BigDecimal(6000));
        setlist.add(map);
        return setlist;
    }
}
