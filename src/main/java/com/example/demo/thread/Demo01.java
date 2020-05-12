package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/5/815:50
 */
@Slf4j
public class Demo01 {

    public static void main(String[] args) {

        TestDemo01 demo01 = new TestDemo01();
        TestDemo01 demo02 = new TestDemo01();
        Thread thread =  new Thread(()->{
                try {
                    demo01.test1();
                    log.debug("thread-1");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });
        thread.setName("thread-1");
        thread.start();
        Thread thread2 =  new Thread(()->{
                try {
                    demo02.test1();
                    log.debug("thread-2");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });
        thread2.setName("thread-2");
        thread2.start();

        demo01.test3();

    }

}
