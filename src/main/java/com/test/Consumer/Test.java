package com.test.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * @Package: com.test.Consumer
 * @ClassName: BiConsumer
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/9 15:17
 */
public class Test {



    static List<Test001> list = new ArrayList<>();
    static {
        list.add(new Test001());
    }

    /*public void test003(){
        list.parallelStream()
                .allMatch()
                .forEach(e->{

            Test001.aa="hello";

        });
    }*/
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        BiConsumer<String, String> biConsumer = (a, b) -> {
            sb.append(a);
            sb.append(b);
        };
        biConsumer.accept("Hello ", "Jack!");
        System.out.println(sb.toString());    // Hello Jack!
    }
}
