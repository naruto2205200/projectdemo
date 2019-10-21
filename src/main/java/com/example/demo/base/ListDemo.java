package com.example.demo.base;

import com.example.demo.domain.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        List<Integer> list2 = new LinkedList<>();
//
//
////        List<Integer> clone = (List<Integer>)((ArrayList<Integer>) list).clone();
//        BeanUtils.copyProperties(list,list2);
//        list.add(3);
//        System.out.println(list);
////        System.out.println(clone);
//        System.out.println(list2);

        User user = new User();
        user.setAge(11);
        user.setName("zhangsan");
        User user2 = new User();
        BeanUtils.copyProperties(user,user2);
        user.setId(2);
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user2==user);

    }
}
