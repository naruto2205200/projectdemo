package com.example.demo.domain;

import java.io.Serializable;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/1610:34
 */
public class Category  implements Serializable {
    private static final long serialVersionUID = 4L;
    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
