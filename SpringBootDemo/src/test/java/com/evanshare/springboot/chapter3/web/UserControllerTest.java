package com.evanshare.springboot.chapter3.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by liangyh on 2017/4/8.
 * Email:10856214@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(
                new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;
        //查询用户列表
        request = get("/user/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
        //新增用户
        request = post("/user/").param("id","1").param("name","haha").param("age","18");
        mvc.perform(request).andExpect(content().string(equalTo("success")));
        //查询用户
        request = get("/user/1");
        mvc.perform(request).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"haha\",\"age\":18}")));
        //查询用户列表
        request = get("/user/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"haha\",\"age\":18}]")));
        //修改用户
        request = put("/user/1").param("name","haha1").param("age","19");
        mvc.perform(request).andExpect(content().string(equalTo("success")));
        //删除用户
        request = delete("/user/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));
    }

}