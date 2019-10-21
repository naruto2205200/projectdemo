package com.example.demo.base;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.SimpleCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/912:27
 */
public class Demo4 {
    public static String DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String[] args) throws ParseException {

//        Date date = stringToDate("2019-09-12");
//        SimpleCalendar.Element element = SimpleCalendar.getCalendarDetail(date);
//
//        System.out.println(JSONObject.toJSON(element));
        System.out.println(7/2);


    }

    public static Date stringToDate(String datestr) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        try {
            date = df.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
