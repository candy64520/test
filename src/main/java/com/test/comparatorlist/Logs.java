package com.test.comparatorlist;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package: com.test.comparatorlist
 * @ClassName: Logs
 * @Author: 86150
 * @Description:
 * @Date: 2021/5/16 14:43
 */
@Data
public class Logs implements Serializable, Comparable<Logs> {

    private String id;
    private String username;
    private String contents;
    private String consequence;
    private String ip;
    private Long times;

    public Logs(String id, String username, String contents, String consequence, String ip, Long times) {
        this.id = id;
        this.username = username;
        this.contents = contents;
        this.consequence = consequence;
        this.ip = ip;
        this.times = times;
    }

    @Override
    public int compareTo(Logs o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", contents='" + contents + '\'' +
                ", consequence='" + consequence + '\'' +
                ", ip='" + ip + '\'' +
                ", times=" + times +
                '}';
    }
}
