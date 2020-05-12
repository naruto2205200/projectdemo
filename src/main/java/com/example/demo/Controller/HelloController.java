package com.example.demo.Controller;

import com.example.demo.domain.*;
import com.example.demo.service.CommentService;
import com.example.demo.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/7/24 9:53
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value="/getlunbo",produces = "application/json;charset=UTF-8")
    public List<User> getlunbo(){
        List<User> userList = UserUtils.getUserList();
        return userList;
    }


    @GetMapping(value="/newList",produces = "application/json;charset=UTF-8")
    public List<News> newList(){
        List<News> newList = new ArrayList<>();
        News news1 = new News();
        news1.setId(1);
        news1.setTitle("哈哈1");
        news1.setReleaseTime("2019-08-08 10:55:20");
        news1.setNumberOfClicks(20);
        news1.setIcon("../../images/shuijiao.jpg");

        News news2 = new News();
        news2.setId(2);
        news2.setTitle("哈哈2");
        news2.setReleaseTime("2019-08-09  12:55:20");
        news2.setNumberOfClicks(10);
        news2.setIcon("../../images/muwu.jpg");

        News news3 = new News();
        news3.setId(3);
        news3.setTitle("哈哈3");
        news3.setReleaseTime("2019-08-07  11:55:20");
        news3.setNumberOfClicks(30);
        news3.setIcon("../../images/cbd.jpg");


        News news4 = new News();
        news4.setId(4);
        news4.setTitle("哈哈4");
        news4.setReleaseTime("2019-08-07  11:55:20");
        news4.setNumberOfClicks(30);
        news4.setIcon("../../images/cbd.jpg");
        News news5 = new News();
        news5.setId(5);
        news5.setTitle("哈哈5");
        news5.setReleaseTime("2019-08-07  11:55:20");
        news5.setNumberOfClicks(30);
        news5.setIcon("../../images/cbd.jpg");
        News news6 = new News();
        news6.setId(6);
        news6.setTitle("哈哈6");
        news6.setReleaseTime("2019-08-07  11:55:20");
        news6.setNumberOfClicks(30);
        news6.setIcon("../../images/cbd.jpg");
        News news7 = new News();
        news7.setId(7);
        news7.setTitle("哈哈7");
        news7.setReleaseTime("2019-08-07  11:55:20");
        news7.setNumberOfClicks(30);
        news7.setIcon("../../images/cbd.jpg");
        News news8 = new News();
        news8.setId(8);
        news8.setTitle("哈哈8");
        news8.setReleaseTime("2019-08-07  11:55:20");
        news8.setNumberOfClicks(30);
        news8.setIcon("../../images/cbd.jpg");
        News news9 = new News();
        news9.setId(9);
        news9.setTitle("哈哈9");
        news9.setReleaseTime("2019-08-07  11:55:20");
        news9.setNumberOfClicks(30);
        news9.setIcon("../../images/cbd.jpg");
        News news10 = new News();
        news10.setId(10);
        news10.setTitle("哈哈10");
        news10.setReleaseTime("2019-08-07  11:55:20");
        news10.setNumberOfClicks(30);
        news10.setIcon("../../images/cbd.jpg");
        newList.add(news1);
        newList.add(news2);
        newList.add(news3);
        newList.add(news4);
        newList.add(news5);
        newList.add(news6);
        newList.add(news7);
        newList.add(news8);
        newList.add(news9);
        newList.add(news10);
        return newList;
    }

    @GetMapping(value = "/newsInfo/{id}" ,produces = "application/json;charset=UTF-8")
    public News getNewsInfo(@PathVariable Integer id){
        News news = new News();
        news.setId(id);
        news.setTitle("这是新闻详情");
        news.setReleaseTime("2019-08-14 10:52:42");
        news.setNumberOfClicks(50);
        news.setContent("这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，" +
                "这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，这是新闻详情，");
        return news;
    }


    @GetMapping(value = "/comments/{newsId}",produces = "application/json;charset=UTF-8")
    public List<Comment> getCommentListByNewsId(@PathVariable Integer newsId){
        return commentService.getCommentListByNewsId(newsId);
    }

    @PostMapping(value = "/addComment", produces = "application/json;charset=UTF-8")
    public int addComment(@RequestBody Comment comment) {
        System.out.println(comment.toString());
        return 1;
    }

    @PostMapping(value = "/addComment2", produces = "application/json;charset=UTF-8")
    public int addComment2(@RequestBody Comment comment) {
        System.out.println(comment.toString());
        return 1;
    }

    @GetMapping(value = "/getAllCategory",produces = "application/json;charset=UTF-8")
    public List<Category> getAllCategory(){
        return commentService.getAllCategory();
    }

    @GetMapping(value = "/getPhotoList/{cateId}",produces = "application/json;charset=UTF-8")
    public List<Photo> getPhotoList(@PathVariable Integer cateId){
        System.out.println(""+cateId);
        return commentService.getPhotoList(cateId);
    }




}
