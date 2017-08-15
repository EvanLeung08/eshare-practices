package com.evanshare.springboot.chapter7.service;

/**
 * Created by liangyh on 2017/8/16.
 * Email:10856214@163.com
 */
public interface UserService {

    void createUser(String name ,Integer age);

    void deleteUserByName(String name);

    Integer queryUsers();

    void deleteAllUsers();


}
