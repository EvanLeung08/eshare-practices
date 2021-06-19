package com.eshare.core.filter;

import com.eshare.core.executor.WebExecutor;
import com.eshare.core.ioc.Inject;
import com.eshare.core.ioc.IocContrainer;
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
    @Inject
    private ActionMapper actionMapper;
    @Inject
    private WebExecutor webExecutor;

    public void init(FilterConfig filterConfig) throws ServletException {
        //创建IOC容器
        //为了保证全局只使用一个ioc容器，这里使用单例模式创建对象
        IocContrainer ioc = IocContrainer.getInstance();
        //注入属性
        ioc.inject(this);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //filter执行过滤器
        System.out.println("filter执行");
        //根据请求找到对应的mapping类
        //ActionMapper actionMapper = new ActionMapper();
        ActionMapping mapping =actionMapper.findMapping(request);
        if(mapping!=null){
          //WebExecutor executor = new WebExecutor();
            //执行用户请求
            webExecutor.execute(request,response,mapping);
        }else {
            //非框架处理部分,继续执行其他环节
            chain.doFilter(request, response);
        }
    }

    public void destroy() {


    }
}
