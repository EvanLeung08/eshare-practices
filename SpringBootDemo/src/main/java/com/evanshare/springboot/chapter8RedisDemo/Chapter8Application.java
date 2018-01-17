package com.evanshare.springboot.chapter8RedisDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liangyh on 2017/8/16.
 * Email:10856214@163.com
 */
@SpringBootApplication(scanBasePackages = "com.evanshare.springboot.chapter8RedisDemo")
@EnableAutoConfiguration
public class Chapter8Application {
    public static void main(String[] args){
        SpringApplication.run(Chapter8Application.class,args);
    }
}
