package com.example.demo.base;

import java.math.BigDecimal;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/2916:09
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
//        System.out.println(BigDecimal.ZERO);


        BigDecimal bigOverTime = new BigDecimal(0);
        BigDecimal thresholdValue = new BigDecimal(30.0);
        BigDecimal subtract = new BigDecimal("2.3");
        System.out.println(thresholdValue.toString());
        System.out.println(subtract.toString());
//        System.out.println(subtract.subtract(thresholdValue));

        BigDecimal startBig = new BigDecimal(bigOverTime.toString());
        BigDecimal endBig = new BigDecimal(subtract.toString());
        bigOverTime = startBig.add(endBig);
        System.out.println(bigOverTime);

    }
}
