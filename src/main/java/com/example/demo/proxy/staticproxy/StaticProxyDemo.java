package com.example.demo.proxy.staticproxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/1810:31
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date parse = format.parse("2017/05/12");

            order.setCreateTime(parse.getTime());
            IOrderService orderService = new OrderServiceStaticProxy(new IOrderServiceImpl());
            orderService.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
