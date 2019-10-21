package com.example.demo.GPBook.chapter.one.openclosedprinciple;

/**
 * @author zhangxiaofeng
 * @Describetion：Java课程优惠
 * @date 2019/9/1715:11
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginPrice(){
        return super.getPrice()*0.61;
    }
}
