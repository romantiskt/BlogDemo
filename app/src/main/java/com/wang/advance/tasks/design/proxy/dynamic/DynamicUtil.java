package com.wang.advance.tasks.design.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * Created by wangyang on 2018/10/23.上午11:52
 */
public class DynamicUtil {

    /**
     * 创建代理类
     * @return
     */
    public static AbstractPerson createProxy() {
        AbstractPerson person = new Boss();
        DynamicInvocationHandler handler = new DynamicInvocationHandler(person);
        AbstractPerson personProxy = (AbstractPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), handler);
        return personProxy;
    }
}
