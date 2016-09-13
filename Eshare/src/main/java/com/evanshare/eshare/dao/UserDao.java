package com.evanshare.eshare.dao;

/**
 * 用户数据库访问类
 * Created by liangyh on 2016/9/13.
 * Email:10856214@163.com
 */
public class UserDao implements IUserDao{

    @Override
    public void save() {
        System.out.println("用户已保存!!!");
    }
}
