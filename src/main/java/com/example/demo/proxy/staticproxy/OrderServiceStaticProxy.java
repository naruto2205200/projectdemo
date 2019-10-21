package com.example.demo.proxy.staticproxy;

import com.example.demo.proxy.DynamicDataSourceEntry;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion：切换数据源的代理类
 * @date 2019/9/1810:24
 */
public class OrderServiceStaticProxy implements IOrderService{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy");
    private IOrderService orderService;
    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService = orderService;
    }
    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(format.format(new Date(time)));
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before(){
        System.out.println("Proxy before method");
    }

    private void after(){
        System.out.println("Proxy after method");
    }
}
