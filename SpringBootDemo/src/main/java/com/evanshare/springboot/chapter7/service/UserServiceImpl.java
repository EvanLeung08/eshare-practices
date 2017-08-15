package com.evanshare.springboot.chapter7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by liangyh on 2017/8/16.
 * Email:10856214@163.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createUser(String name,Integer age) {

        jdbcTemplate.update("insert into user(name,age) value(?,?)",name,age);

    }

    @Override
    public void deleteUserByName(String name) {
        jdbcTemplate.update("delete from user where name =?",name);
    }

    @Override
    public Integer queryUsers() {
        return  jdbcTemplate.queryForObject("select count(1) from user",Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user");
    }
}
