package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2020/4/916:50
 */
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 2L;

    private Integer id;
    private String author;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishDate;
    private String remark;
}
