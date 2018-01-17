package com.evanshare.springboot.chapter9MongoDemo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by liangyh on 2018/1/17.
 * Email:10856214@163.com
 */
public class User {
    @Id
    private Integer id;
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
