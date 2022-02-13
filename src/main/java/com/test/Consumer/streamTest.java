package com.test.Consumer;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.Test;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @Package: com.test.Consumer
 * @ClassName: streamTest
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/9 15:55
 */
public class streamTest {


    @Test
    public void test002(){

        List<Customer> allCustomers= new ArrayList<>();
        allCustomers.add( new Customer("candy",18,new Use("河南",22)));
        allCustomers.add( new Customer("candy",30,new Use("深圳",33)));
        allCustomers.add( new Customer("candy3",18,new Use("河南",11)));
        allCustomers.add( new Customer("candy4",80,new Use("河南",88)));
        allCustomers.add( new Customer("candy3",12,new Use("深圳",66)));


        Map<String, Customer> customerMap = allCustomers.stream()
                .collect(groupingBy(Customer::getName,
                        collectingAndThen(maxBy(Comparator.comparing(Customer::getAge)), Optional::get)
                ));

        System.out.println(JSONObject.toJSON(customerMap));

        allCustomers.stream()
                .filter(customer -> customer.getAge() > 20)
                .map(Customer::getName)
                .forEach(System.out::println);
        System.out.println("----"+JSONObject.toJSON(allCustomers));
//        allCustomers.stream().map(Customer::getName).collect(joining(","));

        Map<Integer, List<Customer>> groupByAge = allCustomers.stream()
                .collect(groupingBy(Customer::getAge));

        System.out.println("--2--"+JSONObject.toJSON(groupByAge));
        if (allCustomers.stream().anyMatch(customer -> customer.getAge() > 20)) {
            System.out.println("全部用户年龄都大于20");
        }
    }

    @Test
    public  void test004() {
        List<Map<String, Object>> list =getlist();
         list.stream()
                .filter(customer ->{
                    if(customer.get("id").equals("1") ){
                        return true;
                    }else {
                        return false;
                    }
                } )
                .map(stu->{

                    return stu.get("name");
                }
        ).forEach(System.out::println);

        System.out.println(JSONObject.toJSON(list));
    }

    public List<Map<String,Object>> getlist(){
        Map<String,Object> map1=new HashMap<>();
        map1.put("id","1");
        map1.put("name","小张");
        map1.put("age","10");
        map1.put("sex","男");
        Map<String,Object> map2=new HashMap<>();
        map2.put("id","2");
        map2.put("name","小李");
        map2.put("age","15");
        map2.put("sex","女");
        Map<String,Object> map3=new HashMap<>();
        map3.put("id","3");
        map3.put("name","小王");
        map3.put("age","30");
        map3.put("sex","男");
        List<Map<String,Object>> list=new ArrayList<>();
        list=  Arrays.asList(map1,map2,map3);
        return list;}


    @Data
    class Customer{
        String name;
        Integer age;

        Use use;

        public Customer(String name, Integer age, Use use) {
            this.name = name;
            this.age = age;
            this.use = use;
        }
    }

    @Data
    class Use{
        String id;
        Integer are;

        public Use(String id, Integer are) {
            this.id = id;
            this.are = are;
        }
    }


    @Test
    public void test001(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> {
            return x % 2 == 0;
        }).map((x) -> {
            return x * x;
        }).forEach(System.out::println);


        String aa="aa";
        System.out.println(aa.toUpperCase());

    }
}
