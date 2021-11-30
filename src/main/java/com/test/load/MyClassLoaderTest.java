package com.test.load;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @Package: com.test.load
 * @ClassName: MyClassLoaderTest
 * @Author: 86150
 * @Description:
 * @Date: 2021/7/31 20:01
 */
public class MyClassLoaderTest {

    static class MyClassLoader  extends ClassLoader{
       private String classpath;

        public MyClassLoader(String classpath) {
            this.classpath = classpath;
        }
  private byte[]  loadByte(String  name)  throws  Exception  {
               name  =  name.replaceAll("\\.",  "/");
               FileInputStream fis  =  new  FileInputStream(classpath  +  "/"  +  name
               +  ".class");
               int  len  =  fis.available();
               byte[]  data  =  new  byte[len];
               fis.read(data);
               fis.close();
               return  data;
               }
        
           protected  Class<?>  findClass(String  name)  throws  ClassNotFoundException  {
               try  {
                   byte[]  data  =  loadByte(name);
                   //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节 数组。
                   return  defineClass(name,  data,  0,  data.length);
                   }  catch  (Exception  e)  {
                   e.printStackTrace();
                   throw  new  ClassNotFoundException();
                   }
               }
    }
			 
    public  static  void  main(String  args[])  throws  Exception  {


        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载
        //   器设置为应用程序类加载器AppClassLoader
        MyClassLoader  classLoader  =  new  MyClassLoader("C:/test");
        //D盘创建  test/com/tuling/jvm  几级目录，将User类的复制类User1.class丢入该目录
        Class  clazz  =  classLoader.loadClass("com.tuling.jvm.Test");
        Object  obj  =  clazz.newInstance();
        Method method  =  clazz.getDeclaredMethod("test2",  null);
        method.invoke(obj,  null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}