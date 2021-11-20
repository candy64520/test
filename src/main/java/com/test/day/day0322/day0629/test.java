package com.test.day.day0322.day0629;

import com.rabbitmq.tools.json.JSONUtil;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Package: com.test.day0629
 * @ClassName: test
 * @Author: 86150
 * @Description:
 * @Date: 2020/6/29 17:26
 */
public class test {

    @Test
    public  void bubbleSort() {

        int arr[] = {12,21,3,4};
        for(int i =0 ; i<arr.length-1 ; i++) {

            for(int j=0 ; j<arr.length-1-i ; j++) {

                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];

                    arr[j]=arr[j+1];

                    arr[j+1]=temp;
                }
            }
        }

        System.out.println(arr.toString());
    }
}
