package com.eshare.core.config;

import com.eshare.core.mapping.Mapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置加载类
 * Created by liangyh on 2016/11/20.
 * Email:10856214@163.com
 */
public class WebConfig {

    private Map<String,Mapping> mappings;

    public WebConfig(){
        //加载映射配置
        loadMappingConfigs();
    }

    /**
     * 加载映射配置
     */
    public void loadMappingConfigs(){
        mappings = new HashMap<String, Mapping>();
        Mapping mapping = new Mapping();
      /*  //模拟框架扫描到所有框架使用者配置的映射配置
        mapping.setClassName("com.eshare.action.PersonAction");
        mapping.setMethodName("hello");
        mapping.setResult("SUCCESS.jsp");
        //模拟配置文件把规则匹配与映射类存放
        mappings.put("hello",mapping);*/
        //通过通配符方式绑定mapping
        mappings.put("*PersonAction",new Mapping("com.eshare.action.PersonAction","{1}","SUCCESS.jsp"));

    }

    public Map<String, Mapping> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, Mapping> mappings) {
        this.mappings = mappings;
    }
}
