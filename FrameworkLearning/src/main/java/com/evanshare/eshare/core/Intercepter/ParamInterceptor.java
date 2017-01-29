package com.evanshare.eshare.core.Intercepter;

import com.evanshare.eshare.core.Action.ActionInvocation;

/**
 * 参数拦截器
 * Created by liangyh on 2016/9/18.
 * Email:10856214@163.com
 */
public class ParamInterceptor  implements Interceptor{

    @Override
    public String intercept(ActionInvocation actionInvocation) {
        String result;
        System.out.println("转换参数之前");
        result = actionInvocation.invoke();
        System.out.println("转换参数之后");
        return result;
    }
}
