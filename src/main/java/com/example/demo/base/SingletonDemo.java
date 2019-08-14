package com.example.demo.base;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/4/814:23
 */
public class SingletonDemo {

    private SingletonDemo(){

    }

    private static class Singleton{
        private static SingletonDemo singletonDemo = new SingletonDemo();
    }

    public static SingletonDemo getSingleton(){
        return Singleton.singletonDemo;
    }
}
