package com.example.demo.lambda;

import com.example.demo.domain.User;
import com.example.demo.utils.ChineseNumber;
import com.example.demo.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/7/1117:38
 */
public class SortDemo {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("aa"));
        if (map.get("aa") != null) {
            System.out.println(1);
        }else{
            System.out.println(2);
        }

        String sourceFileName = "fowefweojfiofja.doc";
        int indexOf = sourceFileName.lastIndexOf(".");
        String preFileName = sourceFileName.substring(0, indexOf);
        String sufFileName =  sourceFileName.substring(indexOf);
        System.out.println(preFileName);
        System.out.println(sufFileName);
        System.out.println(sufFileName);
        System.out.println();

        List<User> userList = UserUtils.getUserList();
        //根据年龄排序
//        Collections.sort(userList,(u1,u2) -> u1.getAge().compareTo(u2.getAge()));

        //筛选固定字段
        List<Integer> collect = userList.stream().map(item -> item.getAge()).collect(Collectors.toList());
        System.out.println("collect:"+collect);

//        //分组
//        Map<Integer, List<User>> collect1 = userList.stream().collect(Collectors.groupingBy(User::getAge));
//        Map<String, List<User>> collect2 = userList.stream().collect(Collectors.groupingBy(item -> item.getAge() + "" + item.getName()));
        //分组后 ，每组的个数
//        Map<String, Long> collect3 = userList.stream().collect(Collectors.groupingBy(item -> item.getAge() + "" + item.getName(), Collectors.counting()));
        //年龄分组
//        Map<Integer, Long> collect4 = userList.stream().collect(Collectors.groupingBy(item -> item.getAge(), Collectors.counting()));

        //过滤
//        List<User> collect2 = userList.stream().filter(item -> item.getAge()==11).collect(Collectors.toList());
//        userList.stream().filter(item->item.getAge()==1)

        //统计
//        list.stream().mapToDouble(User::getHeight).sum()//和
//        list.stream().mapToDouble(User::getHeight).max()//最大
//        list.stream().mapToDouble(User::getHeight).min()//最小
//        list.stream().mapToDouble(User::getHeight).average()//平均值
        //list转map
//        accounts.stream().collect(Collectors.toMap(Account::getId, Account::getUsername));
//        accounts.stream().collect(Collectors.toMap(Account::getId, account -> account));


    }
}
