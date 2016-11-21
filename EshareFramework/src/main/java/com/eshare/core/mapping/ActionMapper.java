package com.eshare.core.mapping;

import com.eshare.core.config.WebConfig;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liangyh on 2016/11/19.
 * Email:10856214@163.com
 */
public class ActionMapper {

    public ActionMapping findMapping(ServletRequest request) {
        ActionMapping actionMapping = new ActionMapping();
        //把请求实体类型转换成HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        //从请求实体中获取Uri
        String uri = req.getRequestURI();
        //根据Uri地址截取用户请求的方法名
        String methodName = uri.substring(req.getContextPath().length() + 1);
        //从配置文件获取所有规则匹配映射
        WebConfig webConfig = new WebConfig();
        Map<String, Mapping> mappings = webConfig.getMappings();
        //根据请求方法名找到匹配的映射类
        Mapping mapping = mappings.get(methodName);
        //根据通配符查找mapping
        if (mapping == null) {
            //遍历所有mappings里的所有key
            Iterator<String> iter = mappings.keySet().iterator();
            while (iter.hasNext()) {
                String matchKey = iter.next();
                //匹配当前请求方法，如匹配则返回对应的mapping
                actionMapping = matchMapping(methodName, matchKey, mappings);
                if (actionMapping != null) {
                    return actionMapping;
                }
            }

        } else {
            return convertActionMapping(methodName, mapping);
        }

        return actionMapping;
    }

    /**
     * 转换ActionMapping
     *
     * @param methodName
     * @param mapping
     */
    private ActionMapping convertActionMapping(String methodName, Mapping mapping) {
        //把mapping转换成对应的actionMapping返回
        ActionMapping actionMapping = new ActionMapping();
        actionMapping.setClassName(mapping.getClassName());
        actionMapping.setMethodName(methodName);
        actionMapping.setResult(mapping.getResult());
        return actionMapping;
    }

    /**
     * 匹配映射
     * <pre>
     *  methodName:helloPersonAction
     *  matchKey: *PersonAction
     *  mapping:new Mapping("com.eshare.action.PersonAction","{1}","SUCCESS.jsp")
     * </pre>
     *
     * @param methodName 方法名
     * @param matchKey   匹配关键字
     * @param mappings   映射配置
     * @return
     */
    private ActionMapping matchMapping(String methodName, String matchKey, Map<String, Mapping> mappings) {
        String regexKey = matchKey;
        //查看当前关键字是否包含通配符*
        if (matchKey.contains("*")) {
            //对通配符替换成正则表达式
            regexKey = matchKey.replaceAll("\\*", "(\\.\\*)");
        }
        //把关键字编译成正则表达式实例
        Pattern pattern = Pattern.compile(regexKey);
        Matcher matcher = pattern.matcher(methodName);
        Mapping mapping;
        //通过正则表达式与方法名相匹配
        if (matcher.find()) {
            //匹配上则通过关键字去查找对应的mapping
            mapping = mappings.get(matchKey);
            //框架使用者配置的方法参数名称
            String configMethod = mapping.getMethodName();
            //请求实际的处理方法
            String method;
            //配置的方法是否有括号,如果存在，则是一个占位符
            if (configMethod.contains("{")) {
                //把所有括号去掉
                configMethod = configMethod.replaceAll("\\{", "").replaceAll("\\}", "");
                //把数字转换成索引
                int index = Integer.valueOf(configMethod);
                //通过matcher的group方法将请求方法与占位符匹配替换
                method = matcher.group(index);
            } else {
                //假如配置方法参数不存在占位符，则直接是最后的执行方法名
                method = configMethod;
            }
            //把解析出来的处理方法名存储到mapping中,替换原来的占位符
            return convertActionMapping(method, mapping);

        }

        return null;

    }
}
