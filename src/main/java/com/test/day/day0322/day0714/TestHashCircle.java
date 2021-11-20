package com.test.day.day0322.day0714;

import com.test.day.day0322.day0714.hash.ConsistentHash;
import com.test.day.day0322.day0714.hash.Node;
import com.test.day.day0322.day0714.hash.HashService;
import com.test.day.day0322.day0714.hash.IHashService;

import java.util.*;

/**
 * @Package: com.test.day0714.hash
 * @ClassName: test
 * @Author: 86150
 * @Description:
 * @Date: 2020/7/14 22:22
 */
public class TestHashCircle {
    // 机器节点IP前缀
    private static final String IP_PREFIX = "192.168.0.";

    public static void main(String[] args) {
        // 每台真实机器节点上保存的记录条数

        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, String> map2 = new HashMap<String, String>();
        // 真实机器节点, 模拟10台
        List<Node<String>> nodes = new ArrayList<Node<String>>();
        for (int i = 1; i <=3; i++) {
            map.put(IP_PREFIX + i, 0); // 初始化记录
            Node<String> node = new Node<String>(IP_PREFIX + i, "node" + i);
            nodes.add(node);
        }

        IHashService iHashService = new HashService();
        // 每台真实机器引入100个虚拟节点
        ConsistentHash<Node<String>> consistentHash = new ConsistentHash<Node<String>>(iHashService, 2, nodes);

        // 将5000条记录尽可能均匀的存储到10台机器节点上
        for (int i = 0; i < 5; i++) {
            // 产生随机一个字符串当做一条记录，可以是其它更复杂的业务对象,比如随机字符串相当于对象的业务唯一标识
            String data = String.valueOf(i);
            // 通过记录找到真实机器节点
            Node<String> node = consistentHash.get(data);
            // 再这里可以能过其它工具将记录存储真实机器节点上，比如MemoryCache等
            // ...
            // 每台真实机器节点上保存的记录条数加1
            map.put(node.getIp(), map.get(node.getIp()) + 1);
           /*if(){

           }
            List list = Arrays.asList(data);
            map2.put(node.getIp(),list.toString());*/
        }

        // 打印每台真实机器节点保存的记录条数
        for (int i = 1; i <= 3; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get(IP_PREFIX + i)+" "+map2.get(IP_PREFIX + i ));
        }
    }
}
