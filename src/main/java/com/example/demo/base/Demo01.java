package com.example.demo.base;

import com.example.demo.domain.User;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/2/116:07
 */
public class Demo01 {
    public static void main(String[] args) {

        System.out.println(assembleNumberStr(0));
        System.out.println(assembleNumberStr(8));
        System.out.println(assembleNumberStr(9));
        System.out.println(assembleNumberStr(98));
        System.out.println(assembleNumberStr(99));
        System.out.println(assembleNumberStr(998));
        System.out.println(assembleNumberStr(999));
        System.out.println(assembleNumberStr(1000));

        String str = "'";
        int len = str.getBytes().length;

//        System.out.println(len);
//        String str1 = "";
//        String str2 ="12";
//        System.out.println(str1.equals(str2));
//
//
//        String start = "2019-02-12";
//        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date parse = format1.parse(start);
//            System.out.println("");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//


        List<User> list = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setAge(11);
        u1.setName("zhangsan");
        list.add(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setAge(12);
        u2.setName("zhangsan");
        list.add(u2);

        User u3 = new User();
        u3.setId(2);
        u3.setAge(11);
        u3.setName("zhangsan2");
        list.add(u3);

        User u4 = new User();
        u4.setId(3);
        u4.setAge(17);
        u4.setName("zhangsan1");
        list.add(u4);

        User u5 = new User();
        u5.setId(4);
        u5.setAge(14);
        u5.setName("zhangsan5");
        list.add(u5);

        User u6 = new User();
        u6.setId(1);
        u6.setAge(13);
        u6.setName("zhangsan1");
        list.add(u6);

        User u7 = new User();
        u7.setId(1);
        u7.setAge(13);
        u7.setName("zhangsan1");
        list.add(u7);

        List<Integer> collect = list.stream().map(item -> item.getId()).collect(Collectors.toList());
        System.out.println(collect);

//        Map<String, IntSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(record -> record.getId() + "" + record.getName(), Collectors.summarizingInt(User::getAge)));
//        Map<Integer, Integer> collect1 = list.stream().collect(Collectors.groupingBy(record -> record.getId(), Collectors.summingInt(User::getAge)));
//        System.out.println(collect);
//
//        BigDecimal b1 = new BigDecimal(0.0);
//        BigDecimal b2 = new BigDecimal(0);
//
//        System.out.println(b1.compareTo(BigDecimal.ZERO)==0);
//        System.out.println(b2.compareTo(BigDecimal.ZERO)==0);
//
//        Float f1 = 0.1F;
//        System.out.println(f1.equals(0.0F));
//        System.out.println(Math.abs(f1)< 0.001);
//        System.out.println(Math.abs(f1)> 0.001);
//
//        BigDecimal b3 = new BigDecimal(12);
//        BigDecimal b4 = new BigDecimal(22);
//        System.out.println(b3.add(b4));
//        b3=b3.add(b4);
//        System.out.println(b3);
//
//        float v = 1 + f1;
//        BigDecimal b5 = new BigDecimal(200).setScale(2,BigDecimal.ROUND_HALF_UP);
//        System.out.println(new BigDecimal(v).setScale(2,BigDecimal.ROUND_HALF_UP));
//        System.out.println(b5.divide(new BigDecimal(v),2,BigDecimal.ROUND_HALF_UP));
//
//
//        Float f3 = 0.1F;
//        System.out.println("f3="+handleFloatToString(f3));
//        BigDecimal taxation1 = new BigDecimal(6000);
//        BigDecimal taxation=taxation1.multiply(new BigDecimal(0.1)).divide(new BigDecimal(1.1),2,BigDecimal.ROUND_HALF_UP);
////               ;
//        System.out.println(taxation.toString());
    }

    /**
     * 处理Float
     * @param sampleArea
     */
    private static String handleFloatToString(Float sampleArea) {
        String out="";
        if (sampleArea != null) {
            if (sampleArea.intValue() - sampleArea == 0) {
                out= sampleArea.intValue()+"免税";
            } else {
                BigDecimal b = new BigDecimal(sampleArea*100);
                sampleArea = b.setScale(0,BigDecimal.ROUND_HALF_UP).floatValue();
                out=sampleArea.intValue() +"%";
            }
        }
        return out;
    }
    private static String assembleNumberStr(int num) {
        String str = "";
        if (num == 0) {
            str="00";
        } else if (num>=1 && num<9) {
            str = "00";
        } else if (num >= 9 && num < 99) {
            str = "0";
        }
        num++;
        str+=num;
        return str;
    }

}
