package com.test.test4;

/**
 * @Package: com.test.test4
 * @ClassName: Lazy
 * @Author: 86150
 * @Description: 懒汉式
 * @Date: 2021/10/30 15:29
 */
public class Lazy {

    private Lazy(){}
    //默认不会实例化，什么时候用什么时候new
    private static Lazy lazy=null;
    public static synchronized Lazy getInstance(){
        if(lazy==null){
            lazy=new Lazy();
        }
        return lazy;
    }

}
