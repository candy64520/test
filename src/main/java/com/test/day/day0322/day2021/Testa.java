package com.test.day.day0322.day2021;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

/**
 * @Package: com.test.day2021
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2021/6/2 21:00
 */
public class Testa {

    public static void main(String[] args) {

//limit方法用来对流进行截取
        String[] arr = {"哈哈","嘻嘻","啵啵"};
        Stream<String> stream = Stream.of(arr);
        Stream<String> stream2 = stream.limit(2);
        stream2.forEach(name-> System.out.println(name));

            short s1 = 1; long l1 = 1;
        System.out.println(s1 == l1);

    }

    @Test
    public  void test82(){
        //创建Optional对象的方式：
        Optional<String> optional = Optional.of("bin");
        Optional<String> optional2 = Optional.ofNullable(null);
        Optional<String> optional3 = Optional.empty();

        //isPresent
        System.out.println(optional.isPresent());

        //get
        System.out.println("-->"+optional2.get());

        //ifPresent
        optional.ifPresent((value)->System.out.println(value));

        //orElse
        System.out.println(optional3.orElse("无值"));

        //orElseGet
        System.out.println(optional3.orElseGet(()->"default"));

        //orElseThrow
        try {
            optional3.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //map方法会自动创建一个Optional对象
        Optional<String> optional4=optional3.map((value)->value.toUpperCase());
        System.out.println(optional4.orElse("no such value"));

        //flatMap不会自己创建，所以需要手动创建封装
        Optional<String> optional5= optional.flatMap((value)->Optional.of(value.toUpperCase()+"-flatMap"));
        System.out.println(optional5.orElse("no found"));

        //filter
        Optional<String> optional6=optional.filter((value)->value.length()>4);
        System.out.println(optional6.orElse("该值长度小于4"));

    }

//    @Test
    public void test(){
        Student student1 = new Student("生命壹号",22,"成都");
        Student student2 = new Student("生命壹号",22,"成都");
        System.out.println(student1==student2);
        System.out.println(student1.equals(student2));
    }


    public static  void test2()throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //指定初始容量15来创建一个HashMap
        HashMap m = new HashMap(15);
        //获取HashMap整个类
        Class<?> mapType = m.getClass();
        //获取指定属性，也可以调用getDeclaredFields()方法获取属性数组
        Field threshold =  mapType.getDeclaredField("threshold");
        //将目标属性设置为可以访问
        threshold.setAccessible(true);
        //获取指定方法，因为HashMap没有容量这个属性，但是capacity方法会返回容量值
        Method capacity = mapType.getDeclaredMethod("capacity");
        //设置目标方法为可访问
        capacity.setAccessible(true);
        //打印刚初始化的HashMap的容量、阈值和元素数量
        System.out.println("容量："+capacity.invoke(m)+"    阈值："+threshold.get(m)+"    元素数量："+m.size());
        for (int i = 0;i<17;i++){
            m.put(i,i);
            //动态监测HashMap的容量、阈值和元素数量
            System.out.println("容量："+capacity.invoke(m)+"    阈值："+threshold.get(m)+"    元素数量："+m.size());
        }
    }


}
