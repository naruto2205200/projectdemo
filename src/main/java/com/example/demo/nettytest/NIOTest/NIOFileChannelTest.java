package com.example.demo.nettytest.NIOTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/5/1216:05
 */
public class NIOFileChannelTest {
    public static void main(String[] args) throws IOException {

        //writefile();
        //readfile();

        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putShort((short) 4);

        buffer.flip();

        System.out.println("=============");

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getShort());
    }

    private static void readfile() throws IOException {
        File file = new File("e:\\filechannel.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        //将数据读入到buffer
        channel.read(byteBuffer);
        //将byte 字节转为String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }

    //写数据
    private static void writefile() throws IOException {
        String str = "hello world!";
        FileOutputStream fileOutputStream = new FileOutputStream("e:\\filechannel.txt");
        FileChannel channel = fileOutputStream.getChannel();

        //把数据放入buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());

        //对buffer反转
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
