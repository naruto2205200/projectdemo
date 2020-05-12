package com.example.demo.nettytest.BIOTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/5/1210:36
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        //线程池机制
        //1、创建一个线程池
        //2、客户端连接则创建一个线程，与之通信
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true) {
            //监听。等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("连接上了");
            threadPool.execute(() ->{
                handler(socket);
            });
        }


    }

    public static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int read = 0;
            while ((read = inputStream.read(bytes))!=-1) {
                    System.out.println(new String(bytes,0,read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭socket");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
