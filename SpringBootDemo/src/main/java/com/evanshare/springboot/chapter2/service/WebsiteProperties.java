package com.evanshare.springboot.chapter2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 网站参数配置
 * Created by liangyh on 2017/4/8.
 * Email:10856214@163.com
 */
@Component
public class WebsiteProperties {
    @Value("${com.evanshare.website.name}")
    private String name;
    @Value("${com.evanshare.website.title}")
    private String title;
    @Value("${com.evanshare.website.decription}")
    private String description;
    @Value("${com.evanshare.website.random.value}")
    private String randomValue;

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
