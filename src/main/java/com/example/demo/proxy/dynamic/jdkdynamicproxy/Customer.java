package com.example.demo.proxy.dynamic.jdkdynamicproxy;

import com.example.demo.proxy.Person;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/1810:50
 */
public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }
}
