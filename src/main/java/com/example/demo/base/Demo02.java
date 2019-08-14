package com.example.demo.base;

import com.example.demo.domain.Person;
import com.example.demo.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/4/89:47
 */
public class Demo02 {
    public static final int LIFHT_SPEED = 30*10000000*1000;
    public static void main(String[] args) {
        System.out.println(String.valueOf(100>11?300:90.0));

        int count =0;
        int mm = 0;
        for (int i = 0; i <10 ; i++) {
            mm = count++;
        }
        System.out.println("count="+count);
        System.out.println("mm="+mm);
        System.out.println(B.c);
        List<String> list = new ArrayList<>();

        long l1 =LIFHT_SPEED*1;
        System.out.println(l1);
//        ExecutorService pool = Executors.newFixedThreadPool(5);
//        pool.submit()
//        new B();
//        Byte b = 2;
//        add(b);

//        Integer i = 1;
//////        System.out.println(b);
////        int[] arr = {5, 6, 8, 2, 4};
////        Arrays.sort(arr);
////        System.out.println(arr.toString());
//        add(i);
//        System.out.println(i);
//        User user = new User();
//
    }


    public static void add(Byte b)
    {
        b++;
        System.out.println(b);
    }

    public static void add(Integer b)
    {
        b+=1;
    }
}

//类加载机制
class A {
    public static String c = "C";


    static {
        System.out.println("A");
    }
}

class B extends A{
    public static String B = "BC";



    static {
        System.out.println("B");
    }
}


class P {
    public static int abc = 123;
    static{
        System.out.println("P is init");
    }
}

class S extends P{
    static{
        System.out.println("S is init");
    }
}