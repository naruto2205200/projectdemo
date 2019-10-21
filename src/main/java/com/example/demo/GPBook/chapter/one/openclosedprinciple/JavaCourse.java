package com.example.demo.GPBook.chapter.one.openclosedprinciple;

/**
 * @author zhangxiaofeng
 * @Describetion：Java课程
 * @date 2019/9/1715:07
 */
public class JavaCourse implements ICourse {
    private Integer id;
    private String name;
    private Double price;
    public JavaCourse(Integer id,String name,Double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Double getPrice() {
        return null;
    }
}
