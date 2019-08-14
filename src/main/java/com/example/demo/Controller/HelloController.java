package com.example.demo.Controller;

import com.example.demo.domain.User;
import com.example.demo.utils.UserUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/7/24 9:53
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(value="/getlunbo",produces = "application/json;charset=UTF-8")
    public List<User> getlunbo(){
        List<User> userList = UserUtils.getUserList();
        return userList;
    }





}
