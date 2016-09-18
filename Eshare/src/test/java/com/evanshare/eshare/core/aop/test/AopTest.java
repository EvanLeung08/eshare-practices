package com.evanshare.eshare.core.aop.test;

import com.evanshare.eshare.core.Action.DefaultActionInvocation;
import com.evanshare.eshare.core.Action.UserAction;
import com.evanshare.eshare.core.Intercepter.Interceptor;
import com.evanshare.eshare.core.Intercepter.ParamInterceptor;
import com.evanshare.eshare.core.Intercepter.PermissionInterceptor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制反转功能测试类
 * Created by liangyh on 2016/9/19.
 * Email:10856214@163.com
 */
public class AopTest {
    @Test
    public void testAop() {
        UserAction action = new UserAction();
        DefaultActionInvocation actionInvocation = new DefaultActionInvocation();
        List<Interceptor> interceptors = new ArrayList<Interceptor>();
        interceptors.add(new ParamInterceptor());
        interceptors.add(new PermissionInterceptor());
        actionInvocation.setAction(action);
        actionInvocation.setInterceptorList(interceptors);
        actionInvocation.invoke();
    }

}
