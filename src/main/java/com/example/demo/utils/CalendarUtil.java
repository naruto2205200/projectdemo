package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion: 日历操作类
 * @date 2019/3/211:39
 */
public class CalendarUtil {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(CalendarUtil.class);

    //日期格式
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static Calendar getCalendar(){
        return Calendar.getInstance();
    }

    /**
     * 设置日历信息
     * @param in
     * @throws ParseException
     */
    public static Calendar setCalendar(String in) throws ParseException {
        Calendar calendar = getCalendar();
        calendar.setTime(getDate(in));
        return calendar;
    }

    /**
     * 设置日历信息
     * @param in
     * @throws ParseException
     */
    public static Calendar setCalendar(Date in){
        Calendar calendar = getCalendar();
        calendar.setTime(in);
        return calendar;
    }

    /**
     * 获取date对象：字符串格式转换为 Date 格式
     * @param in
     * @return
     * @throws ParseException
     */
    public static Date getDate(String in) throws ParseException {
        return dateFormat.parse(in);
    }

    /**
     * 返回 date对象的字符串格式
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {
        return dateFormat.format(date);
    }



    /**
     * 本年的第 N 天
     * @param in
     * @return
     */
    public static int dayOfYear(Date in) {
        Calendar calendar = getCalendar();
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        logger.info("输入日期是今年的第{}天",dayOfYear);
        return dayOfYear;
    }

    /**
     * 本月第 N 天
     * @param in
     * @return
     */
    public static int dayOfMonth(Date in) {
        Calendar calendar = getCalendar();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        logger.info("输入日期是当前月份的第{}天",dayOfMonth);
        return dayOfMonth;
    }

    /**
     * 本周第 N 天
     * @param in
     * @return
     */
    public static int dayOfWeek(Date in) {
        Calendar calendar = getCalendar();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        logger.info("输入日期是当前一周的第{}天",dayOfWeek);
        return dayOfWeek;
    }

    /**
     * 本年有多少天
     * @param in
     * @return
     */
    public static int daysOfYear(Date in) {
        Calendar calendar = getCalendar();
        calendar.setTime(in);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
        return actualMaximum;
    }

    /**
     * 本月有多少天
     * @param in
     * @return
     */
    public static int daysOfMonth(Date in) {
        Calendar calendar = getCalendar();
        calendar.setTime(in);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return actualMaximum;
    }

}
