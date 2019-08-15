package com.example.demo.domain;

import java.io.Serializable;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/1513:54
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 3L;

    private Integer id;
    private Integer newsId;
    private String userName;
    private String addTime;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                "newsId=" + newsId +
                ", userName='" + userName + '\'' +
                ", addTime='" + addTime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
