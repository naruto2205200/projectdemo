package com.example.demo.base;

import java.util.*;
import java.util.stream.Collectors;

public class SetDemo {
    int count = 21;
    public void count() {
        System.out.println(++count);
    }
    public static void main(String args[]) {
//        String str=null;
//        str.concat("abc");
//        str.concat("123");
//        System.out.println(str);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> collect =  list1.stream().filter(item -> item == 2).collect(Collectors.toList());

        System.out.println(collect);

    }
}
