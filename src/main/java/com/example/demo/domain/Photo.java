package com.example.demo.domain;

import java.io.Serializable;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/1613:46
 */
public class Photo implements Serializable {
    private static final long serialVersionUID = 5L;
    private Integer id;
    private Integer cateId;
    private String imgUrl;
    private String title;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
