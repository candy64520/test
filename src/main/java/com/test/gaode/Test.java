package com.test.gaode;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collection;

import com.alibaba.fastjson.JSONObject;
import org.reflections.ReflectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

public class Test {

    @org.junit.Test
    public void test2() throws IOException {


        String res = FileUtils.readFileToString(new File("C:\\workProject\\360\\test_data\\data\\test90.txt"), "UTF-8");

        GaoDeEntity gaoDeEntity = JSONObject.parseObject(res, GaoDeEntity.class);

        GaoDeEntity entity = doentity(gaoDeEntity);

        System.out.println("pumaRiskInfo："+JSON.toJSONString(entity));

    }
    
    /**
     * 对高德数据进行特殊处理
     * 场景：高德返回的数据，如果有值就是String，没有数据就是[]
     */
    public static GaoDeEntity doentity(GaoDeEntity gaoDeEntity){
        List<GeocodesEntity> geocodes = gaoDeEntity.getGeocodes();
        List<GeocodesEntity>  geocodesDomainList = geocodes.stream().filter(domain->{
            //判断数据的值是否为[]
            if (checkFieldAllNull(domain)){
                //利用反射 对bean进行赋值为null
                byMethod(domain);
                return true;
            }

            return true;
        }).collect(Collectors.toList());
        gaoDeEntity.setGeocodes(geocodesDomainList);
        return gaoDeEntity;
    }

    /**
     * 利用反射 对bean进行赋值为null
     * @param t
     * @param <T>
     * @return
     */
    private static <T> T byMethod(T t) {
        ReflectionUtils.getAllMethods(t.getClass(), method ->
                Objects.requireNonNull(method).getName().indexOf("set") == 0)
                .forEach(method -> {
                    try {
                        method.invoke(t, new Object[]{null});
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        
                    }
                });
        return t;
    }

    /**
     * 判断数据的值是否为[]
     * @param object
     * @return
     * @throws IllegalAccessException
     */
    private static boolean checkFieldAllNull(Object object) {
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (Modifier.isFinal(f.getModifiers()) && Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                if (!isEmpty(f.get(object)) ) {
                    return false;
                }
                f.setAccessible(false);
            }
            return true;
        } catch (IllegalAccessException e) {
        }
        return false;
    }

    private static boolean isEmpty(Object object) throws IllegalAccessException {
        if (object == null) {
            return true;
        }
        if (object instanceof String &&  Objects.equals(object.toString(),"[]")) {
            return true;
        }
        if (object instanceof Collection && ((Collection) object).isEmpty()) {
            return true;
        }
        if (object instanceof Object) {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (Modifier.isFinal(f.getModifiers()) && Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                if (f.get(object) instanceof Collection &&  ((Collection) f.get(object)).isEmpty()) {
                    return true;
                }
                f.setAccessible(false);
                return false;
            }
            return true;
        }

        return false;
    }

}
