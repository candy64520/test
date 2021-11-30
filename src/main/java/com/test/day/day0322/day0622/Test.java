package com.test.day.day0322.day0622;

/**
 * @Package: com.test.day0622
 * @ClassName: Test
 * @Author: 86150
 * @Description: yy
 * @Date: 2020/6/20 13:06
 */
public class Test
{

    public static void main(String[] args) {
        int test = 1;
        int test2 =1;

        System.out.println(test==test2);


        int test1 = 22;
        int test3 = test1;
        test3=33;
        System.out.println(test1);//输出22
        System.out.println(test3);//输出33
        System.out.println(test1==test3);


        int[] arr1 = {1,2,3,4};
        int[] arr2 = arr1;
        arr2[0] = 10;
        for(int i = 0;i < arr1.length;i++){
            System.out.println(arr1[i]);
        }//输出结果为：  [10,2,3,4]
        System.out.println(arr1==arr2);

    }

    @org.junit.Test
    public void test(){
        String str1 = "kaka";
        String str2 = str1;
//        str2 = "ccc";
        System.out.println(str1 == str2);//输出false
        System.out.println(str1);//输出kaka
        System.out.println(str2);//输出ccc
    }

    @org.junit.Test
    public  void test3() {
        int ss =0;
        System.out.println(ss++);
        int bb = ss++;
        int cc =++ss;

        System.out.println(bb);
        System.out.println(ss);
        System.out.println(cc);


    String a = new String("aa");
    String b = new String("aa");

    //a与b值相同、但是指向地址不同
//    System.out.println(a == b); //false
//    System.out.println(a.equals(b));//true

    String i1 = "aa";
    String i2 = "aa";

        System.out.println(a.hashCode()==i1.hashCode());
    //i1与i2值相同、指向地址也相同
//    System.out.println(i1 == i2);//true
//    System.out.println(i1.equals(i2));//true

    //i1与a值相同、指向指向地址不同
    System.out.println(i1 == a);//false
    System.out.println(i1.equals(a));//true
}

}
