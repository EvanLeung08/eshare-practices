package com.evanshare.springboot.chapter8RedisDemo.model;

import java.io.Serializable;

/**
 * Created by liangyh on 2018/1/16.
 * Email:10856214@163.com
 */
public class User implements Serializable {

    private String userName;
    private Integer age ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
