package com.example.demo.nettytest.NIOTest;

import java.nio.IntBuffer;

/**
 * @author zhangxiaofeng
 * @Describetion:Buffer的使用
 * @date 2020/5/1213:53
 */
public class BaseBUffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        intBuffer.put(10);
        intBuffer.put(11);
        intBuffer.put(12);
        intBuffer.put(13);
//        intBuffer.put(14);
        //读写切换（必须有此步骤）
        intBuffer.flip();

        //读取数据，intBuffer.hasRemaining() 用来判断是否有元素
        while (intBuffer.hasRemaining()) {
            //get内部维护一个索引，取一次后移一次
            System.out.println(intBuffer.get());
        }


    }
}
