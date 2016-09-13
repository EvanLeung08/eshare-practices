package com.evanshare.eshare.reflect.test;

import com.evanshare.eshare.entity.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liangyh on 2016/9/11.
 * Email:10856214@163.com
 */
public class ReflectApiTest {


    /**
     * 测试获取类的Class
     */
    @Test
    public void testGetClassObj() throws ClassNotFoundException {
        // Class clazz = Boolean.TYPE;
        Class clazz1 = User.class;
        Class clazz2 = Class.forName("com.evanshare.eshare.entity.User");
        Class clazz3 = new User().getClass();
        // System.out.println(clazz);
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
    }

    /**
     * 测试获取类的字段
     */
    @Test
    public void testGetClassFields() {
        Class clazz = User.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
    }

    /**
     * 测试获取构造函数
     */
    @Test
    public void testGetClassConstructor() {
        Class clazz = User.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName());
        }
    }

    /**
     * 测试获取方法
     */
    @Test
    public void testGetMethods() {
        Class clazz = User.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }

    /**
     * 测试属性的读取与赋值
     */
    @Test
    public void testFieldSetterAndGetter() throws Exception {
        Class clazz = User.class;
        Object obj = clazz.newInstance();
        Field ageField = clazz.getDeclaredField("age");
        Field nameField = clazz.getDeclaredField("name");
        //暴力获取权限
        ageField.setAccessible(true);
        nameField.setAccessible(true);
        //对字段赋值
        ageField.setInt(obj, 22);
        nameField.set(obj,"张三");
        System.out.println("年龄:"+ageField.getInt(obj));
        System.out.println("姓名:"+nameField.get(obj));
    }

    /**
     * 测试方法调用
     */
    @Test
    public void testInvokeMethod() throws Exception {
        Class clazz = User.class;
        Object obj = clazz.newInstance();
        //获取set Method对象
        Method setMethod = clazz.getDeclaredMethod("setName",String.class);
        //调用setName方法
        setMethod.invoke(obj,"张三");
        //获取get method 对象
        Method getMethod = clazz.getDeclaredMethod("getName");
        String name = (String) getMethod.invoke(obj);
        System.out.println("姓名:"+name);
    }
}
