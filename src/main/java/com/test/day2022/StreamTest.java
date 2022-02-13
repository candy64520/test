package com.test.day2022;

/**
 * @Package: com.test.day2022
 * @ClassName: StreamTest
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/7 0:20
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Use use = new Use("candy","iiiiii");
        list.add(new Student(1,"男",18,new BigDecimal(100),use));
        list.add(new Student(2,"男",19,new BigDecimal(90),use));
        list.add(new Student(3,"女",20,new BigDecimal(80),use));
        list.add(new Student(4,"女",20,new BigDecimal(70),use));
        list.add(new Student(5,"女",20,null,use));



        User user = new User();
        user.setStudentList(list);




        Map<String, BigDecimal> scoreCount2 = list.stream()
                .filter(t -> t.getScore() != null)
                .collect(Collectors.groupingBy(e->{
                    Use u = e.getUse();
                   return u.getId();
                        },
                        CollectorsUtil.maxBy(f->{
                            return new BigDecimal(f.getUse().getId());
                        })));
        System.out.println("----按照性别分组求分数总和----");
        scoreCount2.forEach((k,v) -> System.out.println("key: " + k + " , " + "value: " + v));



        //单条件筛选
        //按照性别分组求分数总和
        Map<String, BigDecimal> scoreCount = list.stream().filter(t -> t.getScore() != null).collect(Collectors.groupingBy(Student::getSex, CollectorsUtil.summingBigDecimal(Student::getScore)));
        System.out.println("----按照性别分组求分数总和----");
        scoreCount.forEach((k,v) -> System.out.println("key: " + k + " , " + "value: " + v));

        //按照性别求分数平均值
        Map<String, BigDecimal> scoreAvg = list.stream()
                .filter(t -> t.getScore() != null)
                .collect(Collectors.groupingBy(Student::getSex, CollectorsUtil.averagingBigDecimal(Student::getScore,2,0)));
        System.out.println("----按照性别求分数平均值----");
        scoreAvg.forEach((k,v) -> System.out.println("key: " + k + " , " + "value: " + v));



        //按照性别年龄分组求分数总和
        Map<String, BigDecimal> ageScoreCount = list.stream().filter(t -> t.getScore() != null).collect(Collectors.groupingBy(p -> fetchGroupKey(p), CollectorsUtil.summingBigDecimal(Student::getScore)));
        System.out.println("----按照性别年龄分组求分数总和----");
        ageScoreCount.forEach((k,v) -> System.out.println("key: " + k + " , " + "value: " + v));

        //按照性别年龄分组求分数平均值
        Map<String, BigDecimal> ageScoreAvg = list.stream()
                .collect(Collectors.groupingBy(p -> fetchGroupKey(p),
                        CollectorsUtil.averagingBigDecimal(Student::getScore,2,1)));
        System.out.println("----按照性别年龄分组求分数平均值----");
        ageScoreAvg.forEach((k,v) -> System.out.println("key: " + k + " , " + "value: " + v));
    }

    //多条件筛选
    //多条件筛选分组属性
    private static String fetchGroupKey(Student stu) {
        return stu.getAge() + "#" + stu.getSex();
    }
}