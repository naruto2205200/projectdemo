package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //解决方法1：注入对象，用来解决问题
    // [C:\Users\hexuhong\AppData\Local\Temp\tomcat.1541434565861045247.2002\work\Tomcat\localhost\ROOT] is not valid
    //解决方法2： 在properties配置文件中 配置临时文件的上传目录
    //spring.servlet.multipart.location= /data/tmp
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("d:/tmp");
        return factory.createMultipartConfig();
    }

}

