package com.evanshare.eshare.core.Action;

/**
 * Created by liangyh on 2016/9/19.
 * Email:10856214@163.com
 */
public class UserAction implements Action {

    @Override
    public String execute() {

        System.out.println("对用户增删改查");

        return "SUCCESS";
    }
}
