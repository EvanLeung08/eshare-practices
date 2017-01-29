package com.evanshare.eshare.core.Intercepter;

import com.evanshare.eshare.core.Action.ActionInvocation;

/**
 * 权限拦截器
 * Created by liangyh on 2016/9/18.
 * Email:10856214@163.com
 */
public class PermissionInterceptor implements Interceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) {
        String result;
        System.out.println("开始检查权限！！！");
        result= actionInvocation.invoke();
        System.out.println("权限检查完毕！！！");
        return result;
    }
}
