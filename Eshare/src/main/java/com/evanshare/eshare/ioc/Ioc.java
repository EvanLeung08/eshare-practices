package com.evanshare.eshare.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by liangyh on 2016/9/13.
 * Email:10856214@163.com
 */
public class Ioc {
    private Properties properties;

    public Ioc() {
        //加载配置
        loadConfig();
    }

    private void loadConfig() {
        InputStream in = Ioc.class.getResourceAsStream("/ioc.properties");
        properties = new Properties();
        try {
            //加载配置文件
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据类获取对象
     *
     * @param name
     * @return
     */
    public Object get(String name) {
        String className = (String) properties.get(name);
        try {
            return Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注入属性
     */
    public void inject(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                //把私有属性变成可访问状态
                f.setAccessible(true);
                f.set(obj, get(f.getName()));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
