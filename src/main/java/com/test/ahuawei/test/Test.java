package com.test.ahuawei.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Package: com.test.ahuawei.test
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2021/11/16 22:45
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //获取个数
            int num = sc.nextInt();
            //  System.out.println("---》"+num);
            //创建TreeSet进行去重排序
            TreeSet set = new TreeSet();
            //输入
            for(int i =0 ; i < num ;i++){
                set.add(sc.nextInt());
            }

            //输出
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }


    //计算字符串最后一个单词的长度，单词以空格隔开。
    public void test1() {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] s = str.split(" ");
            int i = s[s.length - 1].length();
            System.out.println(i);
        }
    }
//计算某字母出现次数
    //使用减法
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        System.out.println(str);
        String s = sc.nextLine().toLowerCase();
        System.out.println(s + "--->" + str.replaceAll(s, ""));

        int num = (str.length() - str.replaceAll(s, "").length());
        System.out.print("---> " + num);
    }

    //明明的随机数
    public void test3() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //获取个数
            int num = sc.nextInt();
            //  System.out.println("---》"+num);
            //创建TreeSet进行去重排序
            TreeSet set = new TreeSet();
            //输入
            for(int i =0 ; i < num ;i++){
                set.add(sc.nextInt());
            }

            //输出
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }

    }
// 字符串分隔
    public void test4() {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String s = input.nextLine();
            while(s.length()>=8){
                System.out.println(s.substring(0,8));
                s=s.substring(8);
            }
            if(s.length()<8 && s.length()>0){
                s+="00000000";
                System.out.println(s.substring(0,8));
            }
        }
    }
    //进制转换
    public void test5() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();

            System.out.println(s.substring(2,s.length()));
            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        }
    }
    //取近似值
    public void test6() {
        Scanner sc = new Scanner(System.in);
        Double d = sc.nextDouble();
        System.out.println((int)Math.round(d));
    }

    //质数因子
    public void test8() {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();

        for (long i = 2; i <= num; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }
    //合并表记录
    public void test9() {
        Scanner sc = new Scanner(System.in);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int num = sc.nextInt();

        for(int i=0;i<num;i++){

            int key = sc.nextInt();
            int value = sc.nextInt();

            if(map.containsKey(key)){
                map.replace(key, map.get(key) + value);
            }else {
                map.put(key, value);
            }

        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }

    }
    //提取不重复的整数
    public void test10() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int temp = 0;
        String  result = "";
        while(num!=0){
            temp =   num%10;
            if(set.add(temp)){
                result = result+temp;
            }
            num = num/10;
        }
        System.out.println(result);
    }
    //字符个数统计
    public void test11() {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        HashSet<Character> hs=new HashSet<Character>();
        for(int i=0;i<str.length();i++)
            hs.add(str.charAt(i));
        System.out.println(hs.size());
    }
    //数字、字符串 颠倒
    public void test12() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuffer strb = new StringBuffer(str);
        strb.reverse();
        System.out.println(strb.toString());
    }
    //句子逆序
    public void test13() {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        String s[]=str.split(" ");
        for(int i=s.length-1;i>=0;i--)
            if(i!=0)
                System.out.print(s[i]+" ");
            else
                System.out.print(s[i]);
    }
    // 求int型正整数在内存中存储时1的个数
    public void test14() {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();    //读取数字
        int n = 0;    //计数变量
        for(int i=0; i < 32; i++){
            if((num&1) == 1)    //如果末位为1则计数
                n++;
            num = num >>> 1;    //无符号右移
        }
        System.out.println(n);
    }

    //字符串排序
    public void test16() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = br.readLine();
        }
        br.close();

        Arrays.sort(ss);

        for(int i = 0; i < n; i++) {
            System.out.println(ss[i]);
        }
    }

    //24点游戏算法
    public void test17() {
        boolean[] visited = new boolean[4];
        int[] nums = new int[4];
        boolean flag = false;

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            for(int i=0;i<4;i++){
                nums[i]=sc.nextInt();
            }
           // dfs(0,0,flag,visited,nums);
            System.out.println(flag);
        }


    }
    /*public static void dfs(int start,double sum,boolean flag,boolean[] visited,int[] nums){
        //递归终止条件, start表示当前的位置 如果四个数字都遍历完了 最后start=4
        if(start==4){
            if(sum==24){
                flag=true;
            }
        }else{
            start++;
            for(int i=0;i<4;i++){
                if(!visited[i]){
                    visited[i]=true;//标记这轮循环中这个值已经访问过
                    dfs(start,sum+nums[i]);
                    dfs(start,sum-nums[i]);
                    dfs(start,sum*nums[i]);
                    dfs(start,sum/nums[i]);
                    visited[i]=false;
                }
            }
        }
    }*/
//坐标移动
    public void test18() throws IOException {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String[] in = bf.readLine().split(";");
                int x = 0;
                int y = 0;
                for(String s : in){
                    // 不满足题目给定坐标规则
                    if(!s.matches("[WASD][0-9]{1,2}")){
                        continue;
                    }
                    int val = Integer.valueOf(s.substring(1));
                    switch(s.charAt(0)){
                        case 'W':
                            y += val;
                            break;
                        case 'S':
                            y -= val;
                            break;
                        case 'A':
                            x -= val;
                            break;
                        case 'D':
                            x += val;
                            break;
                    }
                }
                System.out.println(x+","+y);
            }

    //简单密码
    public void test19() {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            char c[]=str.toCharArray();
            for(int i=0;i<str.length();i++){
                if(c[i]>='A'&&c[i]<='Z'){
                    if(c[i]+32!='z')
                        c[i]+=32+1;
                    else
                        c[i]='a';
                }
                else if(c[i]>='a'&&c[i]<='r')
                    c[i]=(char) ((c[i]-'a')/3+2+'0');
                else if(c[i]=='s')
                    c[i]='7';
                else if(c[i]>='t'&&c[i]<='v')
                    c[i]='8';
                else if(c[i]>='w'&&c[i]<='z')
                    c[i]='9';

                System.out.print(c[i]);
            }
            System.out.println();
        }

    }


    //简单错误记录
    public void test20() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new LinkedHashMap();
        String tstr = null;
        while((tstr = bf.readLine()) != null && !tstr.equals("")){
            String[] str = tstr.split("\\s+");
            String fname=str[0].substring(str[0].lastIndexOf("\\") + 1);
            fname = fname.substring(Math.max(fname.length()-16 ,0))+" "+str[1];
            Integer tmp = map.get(fname);
            if(tmp == null)
                map.put(fname,1);
            else
                map.put(fname, tmp+1);
        }
        int count = 0;
        for(Map.Entry<String,Integer> it : map.entrySet()){
            if(map.size() - count <= 8)
                System.out.println(it.getKey()+" "+it.getValue());
            count++;
        }
    }


    public void test21() {

    }

    public void test22() {

    }

    public void test23() {

    }


    public void test24() {

    }


    public void test25() {

    }


    public void test26() {

    }


    public void test27() {

    }


    public void test28() {

    }


    public void test29() {

    }


    public void test30() {

    }

    public void test31() {

    }

    public void test32() {

    }

    public void test33() {

    }
    public void test34() {

    }


    public void test35() {

    }


    public void test36() {

    }

    public void test37() {

    }


    public void test38() {

    }

    public void test39() {

    }

    public void test40() {

    }
    public void test41() {

    }

    public void test42() {

    }

    public void test43() {

    } public void test44() {

    }

    public void test46() {

    }

    public void test47() {

    } public void test48() {

    }

    public void test49() {

    }

    public void test50() {

    } public void test51() {

    }

    public void test52() {

    }

    public void test53() {

    }


}