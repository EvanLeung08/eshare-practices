package com.evanshare.springboot.chapter6.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liangyh on 2017/5/2.
 * Email:10856214@163.com
 */
@RestController
public class ExceptionController {
    @RequestMapping("/helloError")
    public String helloError() throws Exception {

        throw new Exception("<Error>:Encounter Exception=>Hello Exception");
    }
}
