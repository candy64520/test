package com.test.test4;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package: com.test.test4
 * @ClassName: test
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/30 15:13
 */
public class test{
    public static void main(String[] args){
        System.out.println(Season.SUMMER);  //输出：SUMMER

        System.out.println("SEASON.SPRING.name --> "+Season.SUMMER.name());
        System.out.println("SEASON.SPRING.toString --> "+Season.SUMMER.toString());
        LinkedList aa = new LinkedList<>();
        ArrayList list = new ArrayList();
        Map map = new HashMap<>();
        Collections.synchronizedMap(map);
        person person = new person();
        collide(person);

        Hashtable hashtable = new Hashtable();
        for (int i=0;i<hashtable.size();i++){

        }
        ReentrantLock lock = new ReentrantLock();

        ThreadLocal local = new ThreadLocal();
        local.get();
        local.set(new Object());

        HashSet set = new HashSet();
        person season = new person();
        season.setAge(11);
        season.setName("222");
        set.add(season);
        person season1 = new person();
        season1.setAge(11);
        season1.setName("222");
        set.add(season1);
        System.out.println(set.toString());
    }


    public static void collide( person car) {
        System.out.println("Collided " + car.test());
    }
}
