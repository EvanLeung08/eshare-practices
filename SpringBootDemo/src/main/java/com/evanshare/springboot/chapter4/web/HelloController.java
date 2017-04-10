package com.evanshare.springboot.chapter4.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liangyh on 2017/4/10.
 * Email:10856214@163.com
 */
@Controller
public class HelloController {

    @RequestMapping("/thymeleaf" )
    public String thymeleaf(ModelMap modelMap){

        modelMap.put("host","www.evanshare.com");

        return "thymeleaf";

    }

}
