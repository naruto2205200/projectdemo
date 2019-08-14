package com.example.demo.base;

import com.example.demo.domain.User;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayDemo {
    public static void main(String[] args) {

        Float fff = 1555F;
        System.out.println("========="+(117/(fff*0.0015)));

        System.out.println("float="+fff.toString());
        String val = fff.toString();
        Map<String, Object> map = new HashMap<>();
        map.put("float",val);

        System.out.println("================="+1%17);
        String[] arr = new String[52];
        for (int i=0;i<arr.length;i++) {
            arr[i] = "√";
        }

        double area = 28293;
        Long plant = 24L;

        System.out.println("========="+(plant/(area*0.0015)));

        Float area1 = 28293F;
        Long plant1 = 24L;
        Integer inaaa = (int)(plant1/(area1*0.0015));

        BigDecimal bd=new BigDecimal(plant1/(area1*0.0015)).setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println("========="+inaaa);
        System.out.println("========="+  bd.toString());


        String ff = "100.0";
        Float mainWastage= 100f;
        Float f = Float.parseFloat( ff );
        //主材损耗费取整
        if(f.intValue()-f==0){//判断是否符合取整条件
            System.out.println(f.intValue()+"%");
        }else {
            System.out.println(f+"%");

        }


//        String[] arr = str.split(",");
//        System.out.println(arr[0]+":"+arr[arr.length-1]);


        System.out.println(0/2);
        System.out.println(1/2);
        System.out.println(2/2);
        System.out.println(3/2);
        System.out.println(4/2);
        System.out.println(5/2);

        Long aaa = 12313131L;
        Long bb = aaa / 1024;

        System.out.println(bb);


        String[] strs = new String[]{};
        int[] int1 = new int[2];
        int[] int2 = new int[]{2};
        int[] int3 = new int[]{2,3,4};
//        String[] strs2 = strs;
//
//        strs2[2] ="dd";
//
//        System.out.println(strs[2]);

        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("zhangsan");
        user1.setId(1);
        list.add(user1);

        User user2 = new User();
        user2.setName("zhangsan");
        user2.setId(2);
        list.add(user2);



        User user3 = new User();
        user3.setName("zhangsan2");
        user3.setId(3);
        list.add(user3);

        User user4 = new User();
        user4.setName("zhangsan3");
        list.add(user4);

        User user5 = new User();
        user5.setName("zhangsan5");
        list.add(user5);

        User user6 = new User();
        user6.setName("zhangsan6");
        list.add(user6);

        List<User> collect2 = list.stream().filter(item -> item.getAge() != null).collect(Collectors.toList());

        Optional<User> max = list.stream().filter(item-> item.getAge()!=null).max(Comparator.comparing(User::getAge));

//        User minUser = min==null?new User():min.get();
        User maxUser = max==null?new User():max.get();



        List<Integer> collect = list.stream().filter(item -> item.getId() != null).map(item -> item.getId()).collect(Collectors.toList());
        System.out.println("=====collect=="+collect);
        List<Integer> collect1 = list.stream().map(item -> item.getId()).collect(Collectors.toList());

        System.out.println("=====collect1"+collect1);

        collect.removeAll(collect1);
        System.out.println("============"+collect);


        List<Integer> list1 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);


        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);


        list1.removeAll(list2);

        System.out.println(list1);





    }
}
