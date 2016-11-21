package com.eshare.core.executor;

import com.eshare.core.mapping.ActionMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by liangyh on 2016/11/19.
 * Email:10856214@163.com
 */
public class WebExecutor {

    public void execute(ServletRequest request, ServletResponse response, ActionMapping mapping) {
        //获取执行请求的类名
        String className = mapping.getClassName();
        //获取执行请求的方法
        String methodName =mapping.getMethodName();
        try {
            //反射创建目标处理类
          Class clazz =  Class.forName(className);
           Object obj = clazz.newInstance();
           Method method =  clazz.getMethod(methodName,null);
            //执行方法
            method.invoke(obj,null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
