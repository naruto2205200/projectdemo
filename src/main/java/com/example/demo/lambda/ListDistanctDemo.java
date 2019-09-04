package com.example.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/2617:35
 */
public class ListDistanctDemo {
    public static void main(String[] args) {



        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        list2.add("d");
        list2.add("");

        List<String> list3 =null;
        List<String> list = new ArrayList<String>(){
            {
                addAll(list2);
                if (list3 != null) {
                    addAll(list3);
                }
            }
        };

        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(111);
        collect.forEach(item-> System.out.println(item));
    }
}
