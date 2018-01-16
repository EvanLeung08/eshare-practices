package com.evanshare.springboot.chapter8;

import com.evanshare.springboot.chapter8.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by liangyh on 2017/8/16.
 * Email:10856214@163.com
 */
@SpringBootApplication(scanBasePackages = "com.evanshare.springboot.chapter8")
@EnableAutoConfiguration
public class Chapter8Application {
    public static void main(String[] args){
        SpringApplication.run(Chapter8Application.class,args);
    }
}
