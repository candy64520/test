package com.test.day2022;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.util.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Package: com.test.day2022
 * @ClassName: Test
 * @Author: 86150
 * @Description:
 * @Date: 2022/1/7 0:06
 */
public class Test {


    public static void main(String[] args) {


        List<HitRuleConfig> configList = getdata();
        Map<String, HitRuleConfig> configMap = configList.parallelStream().collect(
                Collectors.groupingBy(HitRuleConfig::getAppId, // 先根据appId分组
                        Collectors.collectingAndThen(
                                Collectors.reducing(( c1,  c2) -> (c1.getVersionSort() > c2.getVersionSort()) ? c1 : c2), Optional::get)));

        System.out.println(JSONObject.toJSON(configMap));
    }

    public static List<HitRuleConfig> getdata(){
        List<HitRuleConfig> configList = new ArrayList<>();
        HitRuleConfig config = new HitRuleConfig();
        config.setAppId("A");
        config.setVersionSort(3);
        configList.add(config);

        config = new HitRuleConfig();
        config.setAppId("A");
        config.setVersionSort(30);
        configList.add(config);

        config = new HitRuleConfig();
        config.setAppId("A");
        config.setVersionSort(123);
        configList.add(config);

        config = new HitRuleConfig();
        config.setAppId("b");
        config.setVersionSort(93);
        configList.add(config);

        config = new HitRuleConfig();
        config.setAppId("b");
        config.setVersionSort(333);
        configList.add(config);

        return configList;
    }
}
