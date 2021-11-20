package com.test.load;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Package: com.test.load
 * @ClassName: OOMTest
 * @Author: 86150
 * @Description:
 * @Date: 2021/8/10 15:14
 */
public class OOMTest {
    public static List<Object> list =new ArrayList<Object>();
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}


