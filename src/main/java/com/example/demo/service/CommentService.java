package com.example.demo.service;

import com.example.demo.domain.Comment;

import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/1513:57
 */
public interface CommentService {
    List<Comment> getCommentListByNewsId(Integer newsId);


}
