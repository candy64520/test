package com.test.gaode003;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Test {


    @org.junit.Test
    public void test() throws IOException {

        System.out.println("回滚测试 最终版");

        String str = FileUtils.readFileToString(new File("C:\\workProject\\360\\test_data\\data\\test90.txt"), "UTF-8");


        GaoDeEntity GaoDeEntity = JSONObject.parseObject(str, GaoDeEntity.class);
        List<GeocodesEntity> geocodes = GaoDeEntity.getGeocodes();

        for (GeocodesEntity geocode : geocodes) {
            Class<? extends GeocodesEntity> clazz = geocode.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(ReflectTag.class)){
                    PropertyDescriptor propertyDescriptor = null;
                    try {
                        propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
                    } catch (IntrospectionException e) {
                        e.printStackTrace();
                    }
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Object value = null;
                    try {
                        value = readMethod.invoke(geocode);

                        String s = value.toString();
                        if ("[]".equals(s.trim())) {
                            writeMethod.invoke(geocode,"");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        System.out.println("geocodes:"+ JSON.toJSONString(geocodes));
    }
}
