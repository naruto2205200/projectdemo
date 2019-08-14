package com.example.demo.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/2/2610:09
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        String s = Calendar.getInstance().getTimeInMillis() + "";
        System.out.println(s);

        String minDate="2018年03月06日";
        String maxDate="2019-03-10";
        String month = "2018年06月";
//        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");//格式化为年月日
        SimpleDateFormat after = new SimpleDateFormat("yyyy年MM月");//格式化为年月日
        SimpleDateFormat aft = new SimpleDateFormat("yyyy-MM-dd");//格式化为年月日
        SimpleDateFormat afs = new SimpleDateFormat("yyyy年MM月");//格式化为年月日
        SimpleDateFormat sdfDay = new SimpleDateFormat("d");//格式化为年月日

        Calendar cal = Calendar.getInstance();
        cal.setTime(aft.parse(maxDate));
        System.out.println(sdfDay.format(cal.getTime())+"============");

//
//        //当月拥有的天数
//        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println("====="+lastDay);
//        String[] days = new String[lastDay];
//        //获取某月最小天数
//        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
//        //设置日历中月份的最小天数
//        cal.set(Calendar.DAY_OF_MONTH, firstDay);
//        days[0]=aft.format(cal.getTime());
//        for (int j = 1; j <lastDay ; j++) {
//            cal.add(Calendar.DAY_OF_MONTH, 1);
//            days[j]=aft.format(cal.getTime());
//            System.out.println("====="+aft.format(cal.getTime()));
//        }

//        firstMonthOfDays(minDate,sdf);
//        lastMonthOfDays(maxDate,aft);
//
//
//        Calendar min = Calendar.getInstance();
//        min.setTime(sdf.parse(minDate));
//        int first = min.get(Calendar.DAY_OF_MONTH);
//        System.out.println("====="+first);
//        getFisrtDayOfMonth(sdf.parse(minDate));
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(sdf.parse(minDate));
////        cal2.setTime();
//        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println("====="+lastDay);
//
//        //设置日历中月份的最大天数
//        cal.set(Calendar.DAY_OF_MONTH, lastDay);
//        String lastDayOfMonth = sdf.format(cal.getTime());
//        System.out.println("====="+lastDayOfMonth);
//
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(sdf.parse(lastDayOfMonth));
//        //获取某月最小天数
//        int firstDay = cal.getMinimum(Calendar.DATE);
//
////        Calendar cal3 = Calendar.getInstance();
////        cal3.setTime(sdf.parse(firstDay));
//
//
//        int result = cal2.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
//        System.out.println(result);
//
//        for (int i = 0; i <result ; i++) {
//            min.add(Calendar.DAY_OF_YEAR, 1);
//            System.out.println(sdfDay.format(min.getTime()));
//        }


    }


    /**
        * 获取某年某月的第一天
        * @Title:getFisrtDayOfMonth
        * @Description:
        * @param:@param year
        * @param:@param month
        * @param:@return
        * @return:String
        * @throws
        */
    public static String getFisrtDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        System.out.println("=============="+firstDayOfMonth);
        for (int i = 1; i <6 ; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            System.out.println("=============="+sdf.format(cal.getTime()));
        }
        return firstDayOfMonth;
    }
    private static String[] lastMonthOfDays(String lastDate, SimpleDateFormat sdf) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(lastDate));
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //当月到指定日期有几天
//        int days = cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println("=====days:"+days);
//        String firstDayOfMonth = sdf.format(cal.getTime());
//        System.out.println("=============="+firstDayOfMonth);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(sdf.parse(lastDate));
        int result = cal2.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
        System.out.println("=====result:"+result);
        String[] strArr = new String[result+1];
        strArr[0] =sdf.format(cal.getTime());
        for (int i = 1; i <=result ; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
//            System.out.println("=============="+sdf.format(cal.getTime()));
            strArr[i]=sdf.format(cal.getTime());
        }

        for (int i = 0; i <strArr.length ; i++) {
            System.out.println("========================================"+strArr[i]);
        }

        System.out.println("========================================");
        return strArr;
    }

    private static String[] firstMonthOfDays(String startDate, SimpleDateFormat sdf) throws ParseException {
        //计算第一个月份
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(startDate));
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("=====lastDay:"+lastDay);
        //设置日历中月份的最大天数
//        Calendar maxDay = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
//        //当月最后一天
//        String lastDayOfMonth = sdf.format(cal.getTime());
//        System.out.println("====="+lastDayOfMonth);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(sdf.parse(startDate));
        //开始和最后一天之间的天数
        System.out.println(""+cal.get(Calendar.DAY_OF_MONTH) +":"+cal2.get(Calendar.DAY_OF_MONTH));
        int result = cal.get(Calendar.DAY_OF_MONTH) - cal2.get(Calendar.DAY_OF_MONTH);

        String[] days = new String[result+1];
        days[0]=startDate;
        for (int i = 1; i <=result ; i++) {
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            days[i]=sdf.format(cal2.getTime());
        }

        for (int i = 0; i <days.length ; i++) {
            System.out.println("========================================"+days[i]);
        }
        return days;
    }
}
