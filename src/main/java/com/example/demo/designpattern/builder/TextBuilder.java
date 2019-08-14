package com.example.demo.designpattern.builder;

/**
 * @author zhangxiaofeng
 * @Describetion：编写纯文本文档
 * @date 2019/3/2210:19
 */
public class TextBuilder extends Builder {
    //StringBuffer 是线程安全的字符操作类
    private StringBuffer buffer = new StringBuffer();
    @Override
    public void makeTitle(String title) {
        buffer.append("================\n");
        buffer.append("[" + title + "]");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append(str + "\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            buffer.append("    " + item + "\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("=======================\n");
    }

    public String getResult(){
        return buffer.toString();
    }
}
