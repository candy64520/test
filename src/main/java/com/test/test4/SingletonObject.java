package com.test.test4;

/**
 * @Package: com.test.test4
 * @ClassName: SingletonObject
 * @Author: 86150
 * @Description:
 * @Date: 2021/10/30 15:23
 */
public class SingletonObject {

   private SingletonObject(){

   }

   private enum Singleton{

       INSTANCE;

       private final SingletonObject singleton ;

       Singleton() {
           singleton = new SingletonObject();
       }

       private SingletonObject getSingleton(){
           return singleton;
       }
   }

   public static SingletonObject getInstance(){
       return Singleton.INSTANCE.getSingleton();
   }

}

