package com.evanshare.springboot.chapter9MongoDemo;

import com.evanshare.springboot.chapter9MongoDemo.model.User;
import com.evanshare.springboot.chapter9MongoDemo.service.UserRespository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liangyh on 2018/1/17.
 * Email:10856214@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Chapter9Application.class )
public class Chapter9ApplicationTest {

    @Autowired
    private UserRespository userRespository;

    @Test
    public void tset(){
        //创建用户
        User user = new User();
        user.setId(1);
        user.setAge(111);
        user.setName("evan");
        userRespository.save(user);

        Assert.assertEquals(111,userRespository.findOne(Long.valueOf(1)).getAge().longValue());
        Assert.assertEquals(111,userRespository.findByName("evan").getAge().longValue());
        Assert.assertEquals(1,userRespository.findAll().size());
        //修改用户
        user.setAge(22);
        userRespository.save(user);
        Assert.assertEquals(22,userRespository.findOne(Long.valueOf(1)).getAge().longValue());
        //删除用户
        userRespository.delete(1L);
        Assert.assertEquals(0,userRespository.findAll().size());



    }

}
