package com.test.day.day0322.day0630;

/**
 * @Package: com.test.day0630
 * @ClassName: Person
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/30 19:28
 */

public class Person {

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String name;
    String birthday;

    public String getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

