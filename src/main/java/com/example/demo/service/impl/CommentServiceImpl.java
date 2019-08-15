package com.example.demo.service.impl;

import com.example.demo.domain.Comment;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/1513:59
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public List<Comment> getCommentListByNewsId(Integer newsId) {
        return getList();
    }


    private List<Comment> getList(){
        List<Comment> resultList = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setNewsId(1);
        comment1.setUserName("李四");
        comment1.setAddTime("2019-08-15 12:12:12");
        comment1.setContent("这条新闻不错！");
        resultList.add(comment1);

        Comment comment2 = new Comment();
        comment2.setId(2);
        comment2.setNewsId(1);
        comment2.setUserName("李四22");
        comment2.setAddTime("2019-08-15 11:12:12");
        comment2.setContent("这条新闻不错！");
        resultList.add(comment2);

        Comment comment3 = new Comment();
        comment3.setId(3);
        comment3.setNewsId(1);
        comment3.setUserName("李四21");
        comment3.setAddTime("2019-08-15 13:12:12");
        comment3.setContent("这条新闻不错！!");
        resultList.add(comment3);

        return resultList;
    }
}
