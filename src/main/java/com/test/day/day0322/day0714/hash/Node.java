package com.test.day.day0322.day0714.hash;

/**
 * @Package: com.test.day0714.hash
 * @ClassName: Node
 * @Author: 86150
 * @Description: 模拟机器节点
 * @Date: 2020/7/14 22:23
 */
public class Node<T> {
    private String ip;
    private String name;

    public Node(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 使用IP当做hash的Key
     *
     * @return String
     */
    @Override
    public String toString() {
        return ip;
    }
}