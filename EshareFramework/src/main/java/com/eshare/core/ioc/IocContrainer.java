package com.eshare.core.ioc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Ioc容器
 * Created by liangyh on 2016/11/24.
 * Email:10856214@163.com
 */
public class IocContrainer {

    private static IocContrainer INSTANCE;

    private static Map<Class,Object> context  = new HashMap<Class,Object>();

    private IocContrainer() {

    }

    /**
     * 获取Ioc容器实例（懒汉模式）
     * @return
     */
    public static synchronized IocContrainer getInstance() {

        if (null == INSTANCE) {
            INSTANCE = new IocContrainer();
        }
        return INSTANCE;
    }


    public void inject(Object obj) {
        //获取所有声明属性
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(Inject.class)){
                //加载实例
               Object fieldObj =  loadClass(field.getType());
                //暴力破解属性的访问权限
                field.setAccessible(true);
                //对目标对象的属性进行注入
                try {
                    field.set(obj,fieldObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 类加载
     * @param clazz
     * @return
     */
    private Object loadClass(Class clazz){

        //创建实例
        Object obj = context.get(clazz);
        if(obj!=null){
            return obj;
        }
        try {
            //创建实例
             obj =  clazz.newInstance();
            //把实例与其字节码映射存放在内存中
            context.put(clazz,obj);
            //继续注入当前对象其属性
            inject(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;

    }


}
