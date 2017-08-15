package com.evanshare.springboot.chapter7;

import com.evanshare.springboot.chapter7.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by liangyh on 2017/8/16.
 * Email:10856214@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Chapter7ApplicationTest {
    @Autowired
    private UserService userService;

    @Before
    public void inti(){
        //初始化数据，删除所有用户
        userService.deleteAllUsers();
    }

    @Test
    public void testCreatUser(){
        //插入5个用户
        userService.createUser("a",11);
        userService.createUser("b",12);
        userService.createUser("c",13);
        userService.createUser("d",14);
        userService.createUser("e",15);

        Assert.assertEquals(5,userService.queryUsers().intValue());

    }

    @Test
    public void testDeleteUser(){
        //刪除所有用戶
        userService.deleteAllUsers();

        assertEquals(0,userService.queryUsers().intValue());


    }


}