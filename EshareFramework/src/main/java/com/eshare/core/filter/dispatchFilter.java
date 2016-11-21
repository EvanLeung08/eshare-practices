package com.eshare.core.filter;

import com.eshare.core.executor.WebExecutor;
import com.eshare.core.mapping.ActionMapper;
import com.eshare.core.mapping.ActionMapping;

import javax.servlet.*;
import java.io.IOException;

/**
 * 核心请求分发过滤器
 * Created by liangyh on 2016/9/21.
 * Email:10856214@163.com
 */
public class DispatchFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //filter执行过滤器
        System.out.println("filter执行");
        //根据请求找到对应的mapping类
        ActionMapper actionMapper = new ActionMapper();
        ActionMapping mapping =actionMapper.findMapping(request);
        if(mapping!=null){
            WebExecutor executor = new WebExecutor();
            //执行用户请求
            executor.execute(request,response,mapping);
        }else {
            //非框架处理部分,继续执行其他环节
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
