package com.example.demo.domain;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/2/2215:19
 */
public class User extends Person {
    private Integer id;
    private String name;
    private Integer age;
    /*头像*/
    private String headPortrait;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "id:"+id+",name:"+name+",age:"+age+",phone:"+super.getPhone()+",address:"
                +super.getAddress()+",headPortrait"+headPortrait;
    }
}
