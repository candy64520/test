package com.test.ahuawei.test;

/**
 * @Package: com.test.ahuawei.test
 * @ClassName: Test5
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/18 19:46
 */
public class Test5 {

    public static void main(String[] args) {
        System.out.println( getResult(5));
    }
    private static int getResult(int i){
        int result=1;
        for(int j=1;j<i;j++){
            result *=j;
        }
        return result;
    }
}
