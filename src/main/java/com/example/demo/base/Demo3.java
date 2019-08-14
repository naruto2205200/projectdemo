package com.example.demo.base;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/7/1817:05
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(0.1*0.1);
//
//        BigDecimal bd = new BigDecimal(55587.96 * 0.0015).setScale(2, BigDecimal.ROUND_HALF_UP);
//        DecimalFormat df = new DecimalFormat("#,###.##");
////        System.out.println(df.format(bd));
//
//        BigDecimal priceWithTax =  new BigDecimal("4".toString()).setScale(2,BigDecimal.ROUND_HALF_UP);;
//        priceWithTax= priceWithTax.multiply(new BigDecimal(150));
//        System.out.println(priceWithTax.setScale(2,BigDecimal.ROUND_HALF_UP));

//        List<Map<String, Object>> currentPlantAmouts = null;
//        Stream<Map<String, Object>> stream = currentPlantAmouts.stream();
        BigDecimal bd = new BigDecimal(2092759.21 /667).setScale(2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat df = new DecimalFormat("#,###.##");
//        map.put("area",df.format(bd)+" 亩");
        System.out.println(df.format(bd));

    }
}
