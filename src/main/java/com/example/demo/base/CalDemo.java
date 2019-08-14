package com.example.demo.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/2/2613:37
 */
public class CalDemo {


    public static void main(String[] args) throws ParseException {
        String minDate="2019-01-02";
        String maxDate="2019-03-25";
        String[][] strings = calDate(minDate, maxDate);

        System.out.println("=========");
    }

    /**
     * 计算间隔月份，并返回标题的数组
     * @param minDate
     * @param maxDate
     */
    private static String[][] calDate(String minDate,String maxDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化为年月日
        SimpleDateFormat after = new SimpleDateFormat("yyyy年MM月");//格式化为年月日
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(minDate));
        max.setTime(sdf.parse(maxDate));
        int result = min.get(Calendar.MONTH) - max.get(Calendar.MONTH);//月份相隔
        int month = (min.get(Calendar.YEAR) - max.get(Calendar.YEAR)) * 12;//年份相隔
        int abs = Math.abs(month + result);
        String[] months = new String[abs+1];
        months[0]=after.format(min.getTime());
        for (int i=1;i<=abs;i++){
            min.add(Calendar.MONTH, 1);
            months[i]=after.format(min.getTime());
        }
        String[][] strArr = new String[months.length][];
        if(months.length==1){
            strArr[0]=firstMonthOfDays(minDate,sdf);
        }else if(months.length==2){
            strArr[0]=firstMonthOfDays(minDate,sdf);
            strArr[1]=lastMonthOfDays(maxDate,sdf);
        }else{
            calDays(minDate,maxDate,months,strArr,sdf,after);
        }
//        calDays(minDate, maxDate, months, strArr,sdf);
        return strArr;
    }

    public static String[][] calDays(String startDate,String endDate,String[] months,String[][] result,SimpleDateFormat sdf,SimpleDateFormat after) throws ParseException {
//        ArrayList<String> result = new ArrayList<String>();
        //声明一个二维数组
        result[0]=firstMonthOfDays(startDate, sdf);
        //计算日期
        for (int i=1;i<months.length;i++){
            Calendar cal = Calendar.getInstance();
            cal.setTime(after.parse(months[i]));
            //当月拥有的天数
            int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            //获取某月最小天数
            int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
            //设置日历中月份的最小天数
            cal.set(Calendar.DAY_OF_MONTH, firstDay);
            String[] days = new String[lastDay];
            days[0]= sdf.format(cal.getTime());
            for (int j = 1; j <lastDay ; j++) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
                days[j]=sdf.format(cal.getTime());
            }
            result[i]=days;
        }
        //最后一个月的天数
        result[months.length-1]= lastMonthOfDays(endDate,sdf);
        return result;
    }

    /**
     * 第一个月拥有的天数
     * @param startDate
     * @param sdf
     * @throws ParseException
     */
    private static String[] firstMonthOfDays(String startDate, SimpleDateFormat sdf) throws ParseException {
        //计算第一个月份
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(startDate));
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(sdf.parse(startDate));
        //开始和最后一天之间的天数
        int result = cal.get(Calendar.DAY_OF_MONTH) - cal2.get(Calendar.DAY_OF_MONTH);
        String[] days = new String[result+1];
        days[0]=startDate;
        for (int i = 1; i <=result ; i++) {
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            days[i]=sdf.format(cal2.getTime());
        }
        return days;
    }

    /**
     * 最后一个月拥有的天数
     * @param lastDate
     * @param sdf
     * @throws ParseException
     */
    private static String[] lastMonthOfDays(String lastDate, SimpleDateFormat sdf) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(lastDate));
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(sdf.parse(lastDate));
        int result = cal2.get(Calendar.DAY_OF_MONTH) - cal.get(Calendar.DAY_OF_MONTH);

        String[] days = new String[result+1];
        days[0] =sdf.format(cal.getTime());
        for (int i = 1; i <=result ; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
//            System.out.println("=============="+sdf.format(cal.getTime()));
            days[i]=sdf.format(cal.getTime());
        }
        return days;
    }
}
