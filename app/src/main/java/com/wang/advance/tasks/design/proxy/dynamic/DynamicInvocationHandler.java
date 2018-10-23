package com.wang.advance.tasks.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wangyang on 2018/10/23.上午11:50
 */
public class DynamicInvocationHandler implements InvocationHandler {

    AbstractPerson person;

    public DynamicInvocationHandler(AbstractPerson person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行代理。。。。。");

        Object invoke = method.invoke(this.person, args);
        return invoke;
    }
}
