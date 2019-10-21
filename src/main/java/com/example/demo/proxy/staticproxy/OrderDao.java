package com.example.demo.proxy.staticproxy;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/9/1810:16
 */
public class OrderDao {
    public int insert(Order order){
        System.out.println("创建order成功");
        return 1;
    }
}
