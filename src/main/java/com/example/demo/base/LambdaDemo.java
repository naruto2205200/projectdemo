package com.example.demo.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/3/1811:18
 */
public class LambdaDemo {
    public static void main(String[] args) {




        Double d0 = 0D;
        System.out.println(d0.equals(0D));


        Float f1 = 5F;
        Float f2 = 99.5F;
        Float f3 =25F;
        Float f4 = 96.2F;
        Double d1 = Double.valueOf("52");
        Float v1 = (float) (f1 * f2 * 0.01);
        Float v2 = (float) (f3 * f4 * 0.01);

        System.out.println("v1=" + v1 + ",v2=" + v2);
//        \v1=4.9750000000000005,v2=24.05
        BigDecimal bd = getBigDecimal(d1);

        System.out.println(bd.toString());
        System.out.println(f4.toString());
        System.out.println(f1.toString());
        System.out.println(d1.toString());

        Double d2 = 21D;
        Double d3 = 26.3D;
        Double d4 = 85.632D;
        Double d5 = 1536.5D;

        BigDecimal b1 = getBigDecimal(d2);
        BigDecimal b2 = getBigDecimal(d3);
        BigDecimal b3 = getBigDecimal(d4);
        BigDecimal b4 = getBigDecimal(d5);
        BigDecimal sum1 = b1.add(b2).add(b3).add(b4);


        BigDecimal sum2 = new BigDecimal(0);
        System.out.println(sum2.doubleValue());

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");

        BigDecimal sum3 = new BigDecimal(100000.23);
        Float v = sum3.floatValue();
        System.out.println(v.toString());

        System.out.println(sum3.floatValue());

    }

    private static BigDecimal getBigDecimal(Double sum) {
        //计算设计密度(四舍五入)
        return new BigDecimal(sum).setScale(1, BigDecimal.ROUND_HALF_UP);
    }


}
