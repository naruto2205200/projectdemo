package com.example.demo.proxy.staticproxy;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/1810:17
 */

public class IOrderServiceImpl implements IOrderService {
    private OrderDao orderDao;

    public IOrderServiceImpl(){
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        return orderDao.insert(order);
    }
}
