package com.test.test4;

import lombok.Data;

/**
 * @Package: com.test.test4
 * @ClassName: person
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/31 10:50
 */
@Data
public class person {
    public int test(){
        System.out.println("090328");
        return 1;
    }

    private int age;
    private String name;

}
