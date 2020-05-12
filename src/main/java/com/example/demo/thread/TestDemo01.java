package com.example.demo.thread;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/5/815:51
 */
public class TestDemo01 {

    public void test1()  {
        synchronized (this) {
            System.out.println("test1");
        }

    }
    public void test2() {
        synchronized (this) {
            System.out.println("test2");
        }
    }

    public void test3() {
        System.out.println("test3");
    }
}
