package com.example.demo.base;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/2/2610:09
 */
public class DateDemo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {

        String format = sdf.format(new Date());
        System.out.println(sdf.format(new Date()));
        String substring = format.substring(format.indexOf("-")+1);
        System.out.println(substring);
//        int dayOfDate = getDayOfDate(new Date());
//        int monthOfDate = getMonthOfDate(new Date());
//        System.out.println(monthOfDate+"-"+dayOfDate);

        //判断是工作日还是休息日
//        boolean weekend = isWeekend(new Date());
//        System.out.println(weekend);


        //获取日期的最后一秒
//        getLast();
//        String s = Calendar.getInstance().getTimeInMillis() + "";
//        System.out.println(s);
//
//        String minDate="2018年03月06日";
//        String maxDate="2019-03-10";
//        String month = "2018年06月";
////        ArrayList<String> result = new ArrayList<String>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");//格式化为年月日
//        SimpleDateFormat after = new SimpleDateFormat("yyyy年MM月");//格式化为年月日
//        SimpleDateFormat aft = new SimpleDateFormat("yyyy-MM-dd");//格式化为年月日
//        SimpleDateFormat afs = new SimpleDateFormat("yyyy年MM月");//格式化为年月日
//        SimpleDateFormat sdfDay = new SimpleDateFormat("d");//格式化为年月日
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(aft.parse(maxDate));
//        System.out.println(sdfDay.format(cal.getTime())+"============");

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

    /**
     * 获取日期的最后一秒
     * @throws Exception
     */
    private static void getLast() throws Exception{
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        String str=format.format(d);
        System.out.println(str);
        Date d2=format.parse(str);
        System.out.println(d2);
        /////////////////得到想要測试的时间整天

        int dayMis=1000*60*60*24;//一天的毫秒-1
        System.out.println("一天的毫秒-1:"+dayMis);

        //返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        long curMillisecond=d2.getTime();//当天的毫秒
        System.out.println("curMillisecond:"+new Date(curMillisecond));

        long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
        System.out.println("resultMis:"+resultMis);

        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //得到我须要的时间    当天最后一秒
        Date resultDate=new Date(resultMis);
        System.out.println("resultDate:"+resultDate);
        System.out.println("FormatResult:"+format2.format(resultDate));

    }

    /**
     * 判断是否是weekend
     * @param date
     * @return
     * @throws ParseException
     */
    public static boolean isWeekend(Date date) throws ParseException {
//        Date date = sdf.parse(sdate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            return true;
        } else{
            return false;
        }

    }

    /**
     * 判断是否是holiday
     * @param sdate
     * @param list
     * @return
     * @throws ParseException
     */
    public static boolean isHoliday(String sdate, List<String> list) throws ParseException {
        if(list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                if(sdate.equals(list.get(i))){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取日期的DAY值
     *
     * @param date 输入日期
     * @return
     */
    public static int getDayOfDate(Date date) {
        int d = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        d = cd.get(Calendar.DAY_OF_MONTH);
        return d;
    }

    /**
     * 获取日期的MONTH值
     *
     * @param date 输入日期
     * @return
     */
    public static int getMonthOfDate(Date date) {
        int m = 0;
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        m = cd.get(Calendar.MONTH) + 1;
        return m;
    }
}
