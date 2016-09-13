package com.evanshare.eshare.service;

import com.evanshare.eshare.dao.IUserDao;

/**
 * Created by liangyh on 2016/9/13.
 * Email:10856214@163.com
 */
public class UserService {
    private IUserDao userDao;

    /**
     * 保存用户
     */
    public void save(){
        System.out.println("开始执行保方法!!!");
        userDao.save();
        System.out.println("用户保存成功!!!");
    }

}
