package com.example.demo.thread;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/5/816:21
 */
public class SingletonDemo {
    public static volatile SingletonDemo singleton;

    public SingletonDemo(){

    }

    public static SingletonDemo getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }
}
