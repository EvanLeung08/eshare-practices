package com.evanshare.springboot.chapter8RedisDemo;

import com.evanshare.springboot.chapter8RedisDemo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by liangyh on 2018/1/16.
 * Email:10856214@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Chapter8Application.class )
public class Chapter8ApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String,User> redisTemplate;
    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("test1","haha");
        assertEquals("haha",stringRedisTemplate.opsForValue().get("test1"));
    }
    @Test
    public void testSaveObject(){
        User user = new User();
        user.setUserName("evan");
        user.setAge(11);
        redisTemplate.opsForValue().set(user.getUserName(),user);

        Assert.assertEquals(11,redisTemplate.opsForValue().get(user.getUserName()).getAge().longValue());
    }
}