package com.example.demo.hash;

import com.example.demo.domain.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) throws ParseException {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        String times = "2016/11/18";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse(times);
        System.out.println(date);

        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setAge(12);
        user1.setName("zs");
        User user2 = new User();
        user2.setId(1);
        user2.setAge(10);
        user2.setName("zs");
        User user3 = new User();
        user3.setId(1);
        user3.setAge(10);
        user3.setName("zs");
        list.add(user1);
        list.add(user2);
        list.add(user3);


        User user = list.get(0);
        user.setName("ssssss");
        System.out.println(user.getName()+"||||||||||||"+list.get(0).getName());
        int sum = list.stream().mapToInt(item -> item.getAge()).sum();
        System.out.println(sum);
        Optional<User> first = list.stream().filter(item -> item.getAge() == 13).findFirst();
        System.out.println(first.isPresent());

    }
}
