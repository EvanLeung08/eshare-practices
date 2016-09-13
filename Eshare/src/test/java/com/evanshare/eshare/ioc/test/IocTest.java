package com.evanshare.eshare.ioc.test;

import com.evanshare.eshare.ioc.Ioc;
import com.evanshare.eshare.service.UserService;
import org.junit.Test;

/**
 * Created by liangyh on 2016/9/14.
 * Email:10856214@163.com
 */
public class IocTest {
    /**
     * 测试将对象注入IOC容器并调用
     */
    @Test
    public void testIoc(){
        UserService  userService = new UserService();
        //把对象注入容器，交给容器管理
        Ioc ioc = new Ioc();
        ioc.inject(userService);
        //调用保存方法
        userService.save();
    }
}
