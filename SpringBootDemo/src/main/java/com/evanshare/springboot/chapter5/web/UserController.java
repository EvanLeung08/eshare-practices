package com.evanshare.springboot.chapter5.web;

import com.evanshare.springboot.chapter3.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by liangyh on 2017/4/8.
 * Email:10856214@163.com
 */
@RestController
public class UserController {

static Map<Long,User> userContain = Collections.synchronizedMap(new HashMap<>());

    /**
     * 获取User列表
     * @return
     */
    @ApiOperation(value="获取用户列表",notes = "")
    @RequestMapping(value = "/user/",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> users = new ArrayList<>(userContain.values());
        //遍历打印user
        users.forEach(user -> System.out.println(String.format("用户ID=%d,用户名=%s,年龄=%d",user.getId(),user.getName(),user.getAge())));
        return users;
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @ApiOperation(value="查询用户信息",notes = "根据用户ID获取用户信息")
    @ApiImplicitParam(name = "user",required = true,dataType = "user",value = "用户详情User")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userContain.get(id);
    }


    /**
     * 创建用户
     * @param user
     * @return
     */
    @ApiOperation(value="创建用户",notes = "创建用户")
    @RequestMapping(value = "/user/",method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user){
       User u =  userContain.get(user.getId());
        if(u ==null){
            userContain.put(user.getId(),user);
            System.out.println("创建用户成功，用户ID为:"+user.getId());
            return "success";
        }else{
            System.out.println("该用户已存在，用户ID为:"+user.getId());
            return "fail";
        }
    }

    /**
     * 修改用户信息
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value="修改用户信息",notes = "根据URL传进来的id进行修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", dataType = "Long", required = true, value = "用户ID"),
            @ApiImplicitParam(name = "user", dataType = "User", required = true, value = "用户数据")
    }
    )
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String modifyUser(@PathVariable Long id, @ModelAttribute User user){
        User u = userContain.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        userContain.put(id,u);
        System.out.println("修改用户成功");
        return "success";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户",notes = "删除用户信息")
    @ApiImplicitParam(name="id",required = true,dataType = "Long",value = "用户ID")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        User u = userContain.get(id);
        if(u!=null){
            userContain.remove(id);
            System.out.println("删除用户成功!");
            return "success";
        }{
            System.out.println("该用户不存在!");
            return "fail";
        }


    }


}
