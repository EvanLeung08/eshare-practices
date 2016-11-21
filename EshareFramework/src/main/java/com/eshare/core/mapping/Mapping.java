package com.eshare.core.mapping;

/**
 * 请求映射类
 * Created by liangyh on 2016/11/19.
 * Email:10856214@163.com
 */
public class Mapping {
    /**
     * 类全限定名
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 返回结果
     */
    private String result;

    public Mapping(){}

    public Mapping(String className, String methodName, String result) {
        this.className = className;
        this.methodName = methodName;
        this.result = result;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
