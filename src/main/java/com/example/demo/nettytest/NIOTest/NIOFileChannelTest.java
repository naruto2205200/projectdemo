package com.example.demo.nettytest.NIOTest;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/5/1216:05
 */
public class NIOFileChannelTest {
    public static void main(String[] args) throws IOException {

        //writefile();
        //readfile();
//        test01();
//        MappedByteBufferTest();

        ScatteringAndGatheringTest();

    }

    /**
     * scattering：将数据写入到buffer时，可以采用buffer数组，一次写入
     * gathering：从buffer读取数据时，可以采用buffer数组，依次读取
     * @throws IOException
     */
    private static void ScatteringAndGatheringTest() throws IOException{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        //绑定端口到socket并启动
        serverSocketChannel.socket().bind(inetSocketAddress);
        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        SocketChannel socketChannel = serverSocketChannel.accept();
        //假定从客户端接收8个字节
        int messageLength = 8;
        while (true) {
            int byteread = 0;
            while (byteread < messageLength) {
                long l = socketChannel.read(byteBuffers);
                //累计读取的字节数
                byteread+=1;
                System.out.println("byteread="+byteread);
                Arrays.asList(byteBuffers).stream().map(buffer -> "position=" + buffer.position() + ",limit=" + buffer.limit()).forEach(System.out::println);
            }
            //每一个都反转
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());
            //将数据读出显示到客户端
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long l = socketChannel.write(byteBuffers);
                byteWrite+=1;
            }
            //将所有buffer都clear
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());
            System.out.println("byteread:" + byteread + ",bytewrite:" + byteWrite + ",messageLength:" + messageLength);
        }
    }

    private static void MappedByteBufferTest() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("e:\\filechannel.txt", "rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();
        //FileChannel.MapMode.READ_WRITE 读写模式，position 起始位置 size 映射到内存的大小
        //表示可以修改的范围是0 - 5
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte)'H');
        randomAccessFile.close();
    }

    private static void test01() {
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
