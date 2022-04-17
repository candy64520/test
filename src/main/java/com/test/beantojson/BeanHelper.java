package com.test.beantojson;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

public class BeanHelper extends BeanUtils {

    static {
        rules = new HashMap<>();
        registerConverter(new DefaultDateConverter(), Date.class);
        registerConverter(new DefaultLocalDateConverter(), LocalDate.class);
        registerConverter(new DefaultLocalDateTimeConverter(), LocalDateTime.class);
    }

    static Map<Class, Converter> rules;

    public static void registerConverter(Converter converter, Class cls) {
        rules.put(cls, converter);
    }

    public interface Converter {
        /**
         * 自定义类型转换
         *
         * @param var1
         * @param var2
         * @param <T>
         * @return
         */
        <T> T convert(Class<T> var1, Object var2);
    }

    public static class DefaultDateConverter implements Converter {
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public <T> T convert(Class<T> targetClass, Object sourceValue) {
            if (sourceValue == null) {
                return null;
            }

            if (targetClass == Date.class) {
                return (T) sourceValue;
            } else if (targetClass == LocalDate.class) {
                Date d = (Date) sourceValue;
                return (T) LocalDate.of(d.getYear(), d.getMonth(), d.getDate());
            } else if (targetClass == LocalDateTime.class) {
                Date d = (Date) sourceValue;
                return (T) LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault());
            } else if (targetClass == String.class) {

                return (T) dateTimeFormatter.format((Date) sourceValue);
            }
            return null;
        }
    }

    public static class DefaultLocalDateConverter implements Converter {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public <T> T convert(Class<T> targetClass, Object sourceValue) {
            if (sourceValue == null) {
                return null;
            }
            LocalDate localDate = (LocalDate) sourceValue;
            if (targetClass == Date.class) {
                return (T) new Date(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
            } else if (targetClass == LocalDate.class) {
                return (T) sourceValue;
            } else if (targetClass == LocalDateTime.class) {
                return (T) LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0);
            } else if (targetClass == String.class) {
                return (T) localDate.format(dateTimeFormatter);
            }
            return null;
        }
    }

    public static class DefaultLocalDateTimeConverter implements Converter {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public <T> T convert(Class<T> targetClass, Object sourceValue) {
            if (sourceValue == null) {
                return null;
            }
            LocalDateTime localDate = (LocalDateTime) sourceValue;
            if (targetClass == Date.class) {
                return (T) Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
            } else if (targetClass == LocalDate.class) {
                return (T) LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
            } else if (targetClass == LocalDateTime.class) {
                return (T) sourceValue;
            } else if (targetClass == String.class) {
                return (T) localDate.format(dateTimeFormatter);
            }
            return null;
        }
    }

    public static <T> T copyProperties(Object source, Class clazz, String... ignoreProperties) {
        Object o = null;
        try {
            o = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("无法实例化" + clazz + "类型");
        }
        copyProperties(source, o, ignoreProperties);
        return (T) o;
    }

    public static <T> T copyProperties(Object source, Supplier<T> target, String... ignoreProperties) {
        T t = target.get();
        copyProperties(source, t, ignoreProperties);
        return t;
    }

    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();

        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null &&
                            (ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType()) || rules.containsKey(readMethod.getReturnType()))) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            Converter converter = rules.get(sourcePd.getPropertyType());
                            if (converter != null) {
                                value = converter.convert(targetPd.getPropertyType(), value);
                            }

                            writeMethod.invoke(target, value);
                        } catch (Throwable ex) {
                            throw new FatalBeanException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                        }
                    }
                }
            }
        }

    }


    /**
     * 这个方法效率极低，不要使用 ，建议使用 BeanHelper.copyListProperties
     *
     * @param obj
     * @param clazz
     * @param <T>
     * @param <Y>
     * @return
     */
    @Deprecated()
    public static <T, Y> List<T> convertList(List<Y> obj, Class<T> clazz) {
        if (obj == null) {
            return null;
        }
        List<T> resultList = JSON.parseArray(JSON.toJSONString(obj), clazz);
        return resultList;
    }

//    public static <T> Page<T> toPage(IPage<?> pageList, Class<T> clazz) {
//
//        if (pageList == null) {
//            return null;
//        }
//
//        Page<T> destPage = new Page<>();
//        destPage.setPages(pageList.getPages());
//        destPage.setSize(pageList.getSize());
//        destPage.setCurrent(pageList.getCurrent());
//        destPage.setTotal(pageList.getTotal());
//        List<T> destList = copyListProperties(pageList.getRecords(), clazz);
//        destPage.setRecords(destList);
//        return destPage;
//    }

    public static <S, T> List<T> copyListProperties(List<S> sources, Class<T> cls, String... ignoreProperties) {
        return copyListProperties(sources, cls, null, ignoreProperties);
    }

    public static <S, T> List<T> copyListProperties(List<S> sources, Class<T> cls, ColaBeanUtilsCallBack<S, T> callBack, String... ignoreProperties) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = null;
            try {
                t = cls.newInstance();
                copyProperties(source, t, ignoreProperties);
                if (callBack != null) {
                    // 回调
                    callBack.callBack(source, t);
                }
                list.add(t);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, String... ignoreProperties) {
        return copyListProperties(sources, target, null, ignoreProperties);
    }

    /**
     * @author Johnson
     * 使用场景：Entity、Bo、Vo层数据的复制，因为BeanUtils.copyProperties只能给目标对象的属性赋值，却不能在List集合下循环赋值，因此添加该方法
     * 如：List<AdminEntity> 赋值到 List<AdminVo> ，List<AdminVo>中的 AdminVo 属性都会被赋予到值
     * S: 数据源类 ，T: 目标类::new(eg: AdminVo::new)
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, ColaBeanUtilsCallBack<S, T> callBack, String... ignoreProperties) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t, ignoreProperties);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
            list.add(t);
        }
        return list;
    }

    @FunctionalInterface
    public interface ColaBeanUtilsCallBack<S, T> {

        void callBack(S t, T s);
    }
}

