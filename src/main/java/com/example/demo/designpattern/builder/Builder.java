package com.example.demo.designpattern.builder;

/**
 * @author zhangxiaofeng
 * @Describetion：builder基类
 * @date 2019/3/2210:05
 */
public abstract class Builder {
    public abstract void makeTitle(String title);

    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();

}
