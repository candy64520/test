package com.test.day.day0322.day0714;

/**
 * @Package: com.test.day0714
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2020/7/14 23:02
 */

import java.util.*;

/**
 * Created by wanggs on 2017/8/23.
 */
public class Test {
    @org.junit.Test
    public void test() {
        SortedMap<String,String> map = null ;
        map = new TreeMap<String,String>() ;   //通过子类实例化接口对象
        map.put("D","DDDDD") ;
        map.put("A","AAAAA") ;
        map.put("C","CCCCC") ;
        map.put("B","BBBBB") ;

        map.put("h","hhhh") ;
        map.put("g","gggg") ;
        System.out.println("第一个元素的key:" + map.firstKey()) ;
        System.out.println("key对于的值为:" + map.get(map.firstKey())) ;
        System.out.println("最后一个元素的key:" + map.lastKey()) ;
        System.out.println("key对于的值为:" + map.get(map.lastKey())) ;
        System.out.println("返回小于指定范围的集合（键值小于“C”）") ;
        for(Map.Entry<String,String> me:map.headMap("C").entrySet()){
            System.out.println("\t|- " + me.getKey() + "-->" + me.getValue()) ;
        }
        System.out.println("返回大于指定范围的集合（键值大于等于“C”）") ;
        for(Map.Entry<String,String> me:map.tailMap("C").entrySet()){
            System.out.println("\t|- " + me.getKey() + "-->" + me.getValue()) ;
        }
        System.out.println("返回部分集合（键值“B”和“D”之间,包括B不包括D）") ;
        for(Map.Entry<String,String> me:map.subMap("B","D").entrySet()){
            System.out.println("\t|- " + me.getKey() + "-->" + me.getValue()) ;
        }

        map.clear();
    }
    /**
     * 第一个元素的key:A
     key对于的值为:AAAAA
     最后一个元素的key:D
     key对于的值为:DDDDD
     返回小于指定范围的集合（键值小于“C”）
     |- A-->AAAAA
     |- B-->BBBBB
     返回大于指定范围的集合（键值大于等于“C”）
     |- C-->CCCCC
     |- D-->DDDDD
     返回部分集合（键值“B”和“D”之间,包括B不包括D）
     |- B-->BBBBB
     |- C-->CCCCC

     */
}
