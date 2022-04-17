package com.test;

import lombok.Data;

@Data
public class user {

    private String name;
    private int age;

    public user(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
