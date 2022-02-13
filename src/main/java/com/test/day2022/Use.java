package com.test.day2022;

import lombok.Data;

import java.util.List;

/**
 * @Package: com.test.day2022
 * @ClassName: Use
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/7 0:57
 */
@Data
public class Use {

   private String id;

   private String name;

    public Use(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
