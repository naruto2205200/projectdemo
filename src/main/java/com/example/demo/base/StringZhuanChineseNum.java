package com.example.demo.base;

import com.example.demo.utils.ChineseNumber;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/514:18
 */
public class StringZhuanChineseNum {
    public static void main(String[] args) {


        String str = "123456.1564";
        String[] split = StringUtils.split(str, '.');
        double num = 123131.231;
        int num2 = 12313;
        String chineseNumber = ChineseNumber.getChineseNumber(num,1);
        System.out.println(chineseNumber);
        chineseNumber = ChineseNumber.getChineseNumber(num,2);
        System.out.println(chineseNumber);
        chineseNumber = ChineseNumber.getChineseNumber(num2,1);
        System.out.println(chineseNumber);
        chineseNumber = ChineseNumber.getChineseNumber(num2,2);
        System.out.println(chineseNumber);
    }
}
