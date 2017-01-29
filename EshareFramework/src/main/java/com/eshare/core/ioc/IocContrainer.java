package com.eshare.core.ioc;

import com.eshare.core.filter.DispatchFilter;

/**
 * Ioc容器
 * Created by liangyh on 2016/11/24.
 * Email:10856214@163.com
 */
public class IocContrainer {

    private static IocContrainer INSTANCE;

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


    public void inject(DispatchFilter dispatchFilter) {
    }
}
