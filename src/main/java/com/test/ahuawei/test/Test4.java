package com.test.ahuawei.test;

import javax.swing.plaf.basic.BasicBorders;
import java.util.*;

/**
 * @Package: com.test.ahuawei.test
 * @ClassName: Test4
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/17 16:15
 */
public class Test4 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String data =  scanner.nextLine();
        String data1 =  scanner.nextLine();

        List list1 =  Arrays.asList(data.split(""));
        List list2 =  Arrays.asList(data1.split(""));

        StringBuffer buffer = new StringBuffer();

        for(int i=0;i<list1.size();i++){
            int aa = Integer.parseInt(list1.get(i).toString());
            for(int j=0;j<list2.size();j++) {
                int bb = Integer.parseInt(list2.get(j).toString());
                if (aa<bb) {
                    buffer.append(aa);
                }
            }
        }
        List datas = Arrays.asList(buffer.toString().split(""));
        TreeSet setdata3 = new TreeSet();
        for(int i=0;i<datas.size();i++){
            setdata3.add(datas.get(i));
        }
        System.out.println(setdata3.toString());
    }

    public void test(){
        Scanner scanner = new Scanner(System.in);
        String data =  scanner.nextLine();
        String data1 =  scanner.nextLine();

        List list1 =  Arrays.asList(data.split(""));
        List list2 =  Arrays.asList(data1.split(""));

        TreeSet setdata3 = new TreeSet();

        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if(list1.get(i).equals(list2.get(j))){
                    buffer.append(list1.get(i));
                    System.out.println(buffer.toString());
                }
            }
        }

        List datas = Arrays.asList(buffer.toString().split(""));
        for(int i=0;i<datas.size();i++){
            setdata3.add(datas.get(i));
        }
        StringBuffer buf = new StringBuffer();
        Iterator iterator = setdata3.iterator();
        while (iterator.hasNext()){
            buf.append(iterator.next());
        }
    }
}
