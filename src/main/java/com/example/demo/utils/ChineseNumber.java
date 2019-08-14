package com.example.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxiaofeng
 * @Describetion：阿拉伯数字转中文数字
 * @date 2019/8/216:17
 */
public class ChineseNumber {
    private static final String[] BEFORE_SCALE = { "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "" };

    private static final String[] AFTER_SCALE = { "角", "分" };

    private static final String DEFAULT_PATH_SEPARATOR = ".";

    private static final Map<String, String> NUMBER_MAPPING = new HashMap<>();
    static {
        NUMBER_MAPPING.put("0", "零");
        NUMBER_MAPPING.put("1", "壹");
        NUMBER_MAPPING.put("2", "贰");
        NUMBER_MAPPING.put("3", "叁");
        NUMBER_MAPPING.put("4", "肆");
        NUMBER_MAPPING.put("5", "伍");
        NUMBER_MAPPING.put("6", "陆");
        NUMBER_MAPPING.put("7", "柒");
        NUMBER_MAPPING.put("8", "捌");
        NUMBER_MAPPING.put("9", "玖");
    }

    /**
     * int转中文数字
     * @param number
     * @return
     */
    public static String getChineseNumber(int number) {
        return getChineseNumber(new Integer(number),1);
    }
    /**
     * Integer转中文数字
     * @param number
     * @return
     */
    public static String getChineseNumber(Integer number) {
        return getChineseNumber(number.toString(), 1);
    }

    /**
     * double转中文数字
     * @param number
     * @return
     */
    public static String getChineseNumber(double number) {
        return getChineseNumber(new Double(number), 1);
    }
    /**
     * Double转中文数字
     * @param number
     * @return
     */
    public static String getChineseNumber(Double number) {
        DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance();
        f.applyLocalizedPattern("#.##");
        return getChineseNumber(f.format(number), 1);
    }
    /**
     * int转中文数字
     * @param number 要转换的int
     * @param outType 输出类型 1、整数 ；2、金额
     * @return
     */
    public static String getChineseNumber(int number,int outType) {
        return getChineseNumber(new Integer(number),outType);
    }
    /**
     * Integer转中文数字
     * @param number  要转换的Integer
     * @param outType 输出类型 1、整数 ；2、金额
     * @return
     */
    public static String getChineseNumber(Integer number,int outType) {
        return getChineseNumber(number.toString(), outType);
    }
    /**
     * double转中文数字
     * @param number  要转换的double
     * @param outType 输出类型 1、整数 ；2、金额
     * @return
     */
    public static String getChineseNumber(double number,int outType) {
        return getChineseNumber(new Double(number), outType);
    }

    /**
     * Double转中文数字
     * @param number  要转换的Double
     * @param outType 输出类型 1、整数 ；2、金额
     * @return
     */
    public static String getChineseNumber(Double number,int outType) {
        DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance();
        f.applyLocalizedPattern("#.##");
        return getChineseNumber(f.format(number), outType);
    }

    /**
     * String转中文数字
     * @param number 需要转换的字符串
     * @param outType 输出类型 1、整数 ；2、金额
     * @return
     */
    public static String getChineseNumber(String number,int outType) {

        String[] numbers = StringUtils.split(number, DEFAULT_PATH_SEPARATOR);
        if (numbers.length > 2) {
            new NumberFormatException("数字格式错误!");
        }
        int length = numbers[0].length();
        int isZero = 0;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < length; i++) {
            String digit = String.valueOf(numbers[0].charAt(i));
            boolean allZero = true; // 如果后继的全部是零,则跳出
            for (int j = i; j < length; j++) {
                if (numbers[0].charAt(j) != '0') {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                boolean hasValue = false;
                for (int z = i; z >= 0; z--) {
                    if (numbers[0].charAt(z) != '0' && length - z <= 7 && length - z >= 5) {
                        hasValue = true;
                        break;
                    }
                }
                // 加万单位
                if ( ( length - i > 4 && length <= 8 ) || ( hasValue && length - i > 4 )) {
                    result.append(BEFORE_SCALE[8]);
                }
                // 加亿单位
                if (length - i >= 9) {
                    result.append(BEFORE_SCALE[4]);
                }
                break;
            }
            if (length < 9 && length - i == 5) {
                if (!"0".equals(digit) && isZero > 0) {
                    result.append(NUMBER_MAPPING.get("0"));
                }
                if ("0".equals(digit)) {
                    result.append(BEFORE_SCALE[8]);
                    if (isZero > 0) {
                        result.append(NUMBER_MAPPING.get("0"));
                    }
                    continue;
                }
            }
            if ("0".equals(digit) && length > 9 && length - i == 9) {
                result.append(BEFORE_SCALE[4]);
                continue;
            }
            if (isZero < 1 || !"0".equals(digit)) {
                if ("0".equals(digit)) {
                    if (length - i != 6 && length - i != 7) {
                        result.append(NUMBER_MAPPING.get(digit));
                    }
                } else {
                    result.append(NUMBER_MAPPING.get(digit));
                }

                if (!"0".equals(digit)) {
                    result.append(BEFORE_SCALE[BEFORE_SCALE.length - length + i]);
                }
            }
            if ("0".equals(digit)) {
                isZero++;
            } else {
                isZero = 0;
            }
        }
        if (numbers.length == 1) {
            if(outType==2) {
                result.append("圆整");
            }
            return result.toString();
        }
        length = numbers[1].length();
        for (int j = 0; j < length; j++) {
            if (j > 2) {
                break;
            }
            if (numbers[1].charAt(j) == '0') {
                continue;
            }
            if(outType==2) {
                result.append(NUMBER_MAPPING.get(String.valueOf(numbers[1].charAt(j))));
                result.append(AFTER_SCALE[j]);
            }
        }
        return result.toString();
    }

}
