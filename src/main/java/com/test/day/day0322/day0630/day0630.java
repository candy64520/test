package com.test.day.day0322.day0630;

import java.util.Optional;

/**
 * @Package: com.test
 * @ClassName: day0630
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/30 18:20
 */
public class day0630 {

    public static void main(String[] args) {
        /**
         * of接收的参数，可能外部传入，可能为空，但是之前的方式真正报空指针还不知道在哪里
         * 但是如果Optional.of则始终都会报在这里，方便快速确定空指针的位置
         */
//        Optional<test2> op=Optional.of(null);


        /**
         * 该种方式是构建一个null，在第一行不会报错，get时候才报错
         */
        Optional<test2> op1=Optional.empty();
        System.out.println(op1.get());

        /**
         * 传递进来能构建就构建对象，否则就构建null
         * 报错也是在get的时候
         * 其实就是of和empty的综合
         */
        Optional<test2> op2=Optional.ofNullable(null);
        System.out.println(op2.get());

        //代表有值才get，等价于非空判断
        if (op2.isPresent()) {
            System.out.println(op2.get());
        }

       /* //如果op有值则获取，否则调用orElse的构造并返回该对象
        test2 test2 = op.orElse(new test2());
        //这个功能类似，只是参数是函数式接口，则可以内部写很复杂的逻辑，甚至根据条件返回不同的结果
        test2 test21 =op.orElseGet(()->new test2());
        test2 test22 =op.orElseGet(test2::new);


        Optional<String> str=  op.map(e->e.getName());
        System.out.println(str.get());//此时获取的就是name而不是全部对象属性


        //和map基本相同，只是返回的必须是Optional,说白了，进一步避免空指针异常
        Optional<String> str2=op.flatMap(e->Optional.of(e.getName()));
        System.out.println(str2.get());*/

    }
}
