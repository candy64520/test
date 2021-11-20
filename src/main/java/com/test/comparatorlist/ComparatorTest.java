package com.test.comparatorlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Package: com.test.comparatorlist
 * @ClassName: ComparatorTest
 * @Author: 86150
 * @Description:
 * @Date: 2021/5/16 13:26
 */
public class ComparatorTest {



    public static void main(String[] args)
    {
        //优先排序规则：
        //年龄从小到大、
        //工资从大到小
        //销量从高到底
        User u1 = new User(11, 22, 33);
        User u2 = new User(11, 212, 34);
        User u3 = new User(11, 99, 35);
        User u4 = new User(21, 22, 33);
        User u5 = new User(31, 22, 33);
        User u6 = new User(41, 22, 33);
        User u7 = new User(51, 220, 33);
        User u8 = new User(51, 222, 33);
        User u9 = new User(51, 226, 77);
        User u10 = new User(51, 226, 33);
        User u11 = new User(11, 22, 330);

        List<User> ulist = new ArrayList<User>();
        ulist.add(u11);
        ulist.add(u10);
        ulist.add(u9);
        ulist.add(u8);
        ulist.add(u7);
        ulist.add(u6);
        ulist.add(u5);
        ulist.add(u4);
        ulist.add(u3);
        ulist.add(u2);
        ulist.add(u1);
        Collections.sort(ulist, comparator);//调用Comparator
        for (User user : ulist)
        {
            System.out.println(user);
        }
    }

    public static Comparator<User> comparator = new Comparator<User>()
    {

        @Override
        public int compare(User o1, User o2)
        {
            // 优先排序规则：
            // 年龄从小到大、
            // 工资从大到小
            // 销量从高到底
            int a = o1.getAge() - o2.getAge();
            if (a != 0)
            {
                return a > 0 ? 3 : -1;//
            }
            else
            {
                a = o2.getSalary() - o1.getSalary();
                if (a != 0)
                {
                    return a > 0 ? 2 : -2;
                }
                else
                {
                    return o2.getSales() - o1.getSales() > 0 ? 1 : -3;
                }
            }
        }
    };
}

