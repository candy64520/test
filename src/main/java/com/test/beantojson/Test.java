package com.test.beantojson;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        Model model =  new Model();

        model.setProperty1("[]");
        model.setProperty2("[]");
        model.setProperty3("[]");
        boolean ret = ObjectIsNullUitl.checkFieldAllNull(model);
        System.out.println("ret:" + ret);
        System.out.println("model:" + JSON.toJSONString(model));
    }

}
