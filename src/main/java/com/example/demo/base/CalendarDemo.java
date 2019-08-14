package com.example.demo.base;

import com.example.demo.utils.CalendarUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion: 日历操作demo
 * @date 2019/3/214:02
 */
public class CalendarDemo {
    public static void main(String[] args) throws ParseException {
        Date date = CalendarUtil.getDate("2019-02-06");
        int i = CalendarUtil.daysOfYear(date);
        System.out.println("年有"+ i +"天");


        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = null;
        list.add(1);

        list.removeAll(list2);

    }
}
