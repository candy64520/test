package com.test.ahuawei.test;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Package: com.test.ahuawei.test
 * @ClassName: Test3   密码验证合格程序
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/17 11:24
 */
public class Test3 {

        public static void main(String[] arg){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String str = sc.next();
                if(str.length() <= 8){
                    System.out.println("NG");
                    continue;
                }
                if(getMatch(str)){
                    System.out.println("NG");
                    continue;
                }
                if(getString(str, 0, 3)){
                    System.out.println("NG");
                    continue;
                }
                System.out.println("OK");
            }
        }
        // 校验是否有重复子串
        private static boolean getString(String str, int l, int r) {
            if (r >= str.length()) {
                return false;
            }
            if (str.substring(r).contains(str.substring(l, r))) {
                return true;
            } else {
                return getString(str,l+1,r+1);
            }
        }
        // 检查是否满足正则
        private static boolean getMatch(String str){
            int count = 0;
            Pattern p1 = Pattern.compile("[A-Z]");
            if(p1.matcher(str).find()){
                count++;
            }
            Pattern p2 = Pattern.compile("[a-z]");
            if(p2.matcher(str).find()){
                count++;
            }
            Pattern p3 = Pattern.compile("[0-9]");
            if(p3.matcher(str).find()){
                count++;
            }
            Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
            if(p4.matcher(str).find()){
                count++;
            }
            if(count >= 3){
                return false;
            }else{
                return true;
            }
        }
}
