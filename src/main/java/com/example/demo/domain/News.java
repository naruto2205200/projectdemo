package com.example.demo.domain;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/1411:02
 */
public class News implements Serializable {
    private static final long serialVersionUID = 2L;
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 发布时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String releaseTime;
    /**
     * 点击次数
     */
    private Integer numberOfClicks;
    /**
     * 图标
     */
    private String icon;
    /**
     * 内容
     */
    private String content;


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

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getNumberOfClicks() {
        return numberOfClicks;
    }

    public void setNumberOfClicks(Integer numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
