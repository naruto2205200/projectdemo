package com.example.demo.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhangxiaofeng
 * @Describetion:创建ApplicationContextInitializer 初始化器，监听
 * @date 2019/11/515:55
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer ... initialize..."+configurableApplicationContext);
    }
}
