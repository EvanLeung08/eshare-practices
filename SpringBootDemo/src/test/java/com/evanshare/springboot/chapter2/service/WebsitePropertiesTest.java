package com.evanshare.springboot.chapter2.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liangyh on 2017/4/8.
 * Email:10856214@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebsitePropertiesTest {

    private static final Log log = LogFactory.getLog(WebsitePropertiesTest.class);
    @Autowired
    private WebsiteProperties websiteProperties;

    @Test
    public void test1(){
        Assert.assertEquals("Eshare",websiteProperties.getName());
        Assert.assertEquals("Eshare知识分享平台",websiteProperties.getTitle());
        Assert.assertEquals("Eshare是一个知识分享平台",websiteProperties.getDescription());
        log.info(websiteProperties.getName());
        log.info(websiteProperties.getTitle());
        log.info(websiteProperties.getDescription());
        log.info(websiteProperties.getRandomValue());
    }

}