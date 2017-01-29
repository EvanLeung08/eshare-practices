package com.evanshare.eshare.core.Action;

import com.evanshare.eshare.core.Intercepter.Interceptor;

import java.util.List;

/**
 * 默认Action调用类
 * Created by liangyh on 2016/9/16.
 * Email:10856214@163.com
 */
public class DefaultActionInvocation implements ActionInvocation {

    private List<Interceptor> interceptorList;
    private Action action;
    private int index=0;

    @Override
    public String invoke() {
        if(interceptorList != null){
            if(index == interceptorList.size()){
                return action.execute();
            }else{
                Interceptor interceptor = interceptorList.get(index);
                index++;
                return interceptor.intercept(this);
            }

        }
        return action.execute();
    }


    public List<Interceptor> getInterceptorList() {
        return interceptorList;
    }

    public void setInterceptorList(List<Interceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
