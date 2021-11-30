package com.test.comparatorlist;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * @Package: com.test.comparatorlist
 * @ClassName: testMath
 * @Author: 86150
 * @Description:
 * @Date: 2021/5/16 14:43
 */
public class testMath {

    @Test
    public void testMath(){
        List<Logs> list = new ArrayList<Logs>();
        list.add(new Logs("1","chen", "djifand", "jdifa", "jdfid", 49L));
        list.add(new Logs("134","ce", "cae", "jdifa", "jdfid", 123L));
        list.add(new Logs("3","cet", "djifand", "jdifa", "jdfid", 99L));
        list.add(new Logs("4","egge", "djifand", "jdifa", "jdfid", 111L));
        list.add(new Logs("15","chen", "djifand", "jdifa", "jdfid", 59L));
        list.add(new Logs("6","chen2", "cae", "jdifa", "jdfid", 123L));
        list.add(new Logs("87","cet", "djifand", "jdifa", "jdfid", 213L));
        list.add(new Logs("8","egge", "djifand", "jdifa", "jdfid", 201L));
        list.add(new Logs("9","egge2", "djifand", "jdifa", "jdfid", 269L));
        list.add(new Logs("10","ce", "cae", "jdifa", "jdfid", 121L));
        list.add(new Logs("11","chen3", "djifand", "jdifa", "jdfid", 1123L));
        list.add(new Logs("5","cet2", "djifand", "jdifa", "jdfid", 12L));

        System.out.println("---- 排序前的输出  ----- ");
        for (Logs logs : list) {
            System.out.println("数据: "+logs);
        }
        System.out.println("---- 排序后的结果  ----- ");
        List<Logs> search = search(list);
        for (Logs logs : list) {
            System.out.println("数据-->: "+logs);
        }

        System.out.println("-1->"+search1(list));

        System.out.println("-2->"+search2(list));

        System.out.println("-3->"+search3(list));


    }

    // 方式1: 降序排列
    public List<Logs> search(List<Logs> logsList){
        Collections.sort(logsList, new Comparator<Logs>() {
            @Override
            public int compare(Logs o1, Logs o2) {
                if ((o1.getTimes() > o2.getTimes())){
                    return -1;
                }
                if (o1.getTimes() == o2.getTimes()){
                    return 0;
                }
                return 1;
            }
        });
        return logsList;
    }

    // 方式2: 升序排列
    public List<Logs> search1(List<Logs> logsList){
        Collections.sort(logsList, new Comparator<Logs>() {
            @Override
            public int compare(Logs o1, Logs o2) {
                if ((o1.getTimes() > o2.getTimes())){
                    return 1;
                }
                if (o1.getTimes() == o2.getTimes()){
                    return 0;
                }
                return -1;
            }
        });
        return logsList;
    }
    // 方式3: 降序排列
    public List<Logs> search2(List<Logs> logsList){
        Collections.sort(logsList, new Comparator<Logs>() {
            @Override
            public int compare(Logs o1, Logs o2) {
                return -o1.getTimes().compareTo(o2.getTimes());
            }
        });
        return logsList;
    }

    // 方式4: 升序排列
    public List<Logs> search3(List<Logs> logsList){
        Collections.sort(logsList, new Comparator<Logs>() {
            @Override
            public int compare(Logs o1, Logs o2) {
                return o1.getTimes().compareTo(o2.getTimes());
            }
        });
        return logsList;
    }
}
