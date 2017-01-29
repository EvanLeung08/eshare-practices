package com.evanshare.eshare.core.Intercepter;

import com.evanshare.eshare.core.Action.ActionInvocation;

/**
 * 拦截器
 * Created by liangyh on 2016/9/16.
 * Email:10856214@163.com
 */
public interface Interceptor {
    String intercept(ActionInvocation actionInvocation);
}
