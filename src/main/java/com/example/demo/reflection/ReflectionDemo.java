package com.example.demo.reflection;

import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 * @Title: ReflectionDemo
 * @ProjectName demo
 * @Description: TODO
 * @date 2019/1/2116:16
 */
public class ReflectionDemo {
    public static void main(String[] args) {
        String path = "group1/M00/00/00/wKhWulxAs2-AB-ywAAPJuNJGBl4156_big.jpg";

//        System.out.println(FilenameUtils.getExtension(file.getOriginalFilename()));
        System.out.println( path.substring(0,path.indexOf('/')));
        System.out.println( path.substring(path.indexOf('/')));

        List<String> list = new ArrayList<>();
        list.add("first");

        list.addAll(new ArrayList<>());

        System.out.println(list);

        Long a = 4L;
        Long b = 4L;

        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
