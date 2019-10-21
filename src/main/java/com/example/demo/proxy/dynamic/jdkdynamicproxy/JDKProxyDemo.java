package com.example.demo.proxy.dynamic.jdkdynamicproxy;

import com.example.demo.proxy.Person;
import com.example.demo.proxy.staticproxy.IOrderService;
import com.example.demo.proxy.staticproxy.IOrderServiceImpl;
import com.example.demo.proxy.staticproxy.Order;
import com.example.demo.proxy.staticproxy.OrderServiceStaticProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/1810:52
 */
public class JDKProxyDemo {
    public static void main(String[] args) {
        //媒婆
//        Person person = (Person)new JDKMeipo().getInstance(new Customer());
//        person.findLove();

        try {
            //动态数据源
            Order order = new Order();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            Date parse = format.parse("2017/05/12");
            order.setCreateTime(parse.getTime());
            IOrderService orderService = (IOrderService) new OrderServiceDaynamicProxy().getInstance(new IOrderServiceImpl());
            orderService.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
