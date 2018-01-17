package com.evanshare.springboot.chapter9MongoDemo.service;

import com.evanshare.springboot.chapter9MongoDemo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by liangyh on 2018/1/17.
 * Email:10856214@163.com
 */
public interface UserRespository extends MongoRepository<User,Long> {

    User findByName(String name);
}
