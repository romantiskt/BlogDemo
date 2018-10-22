package com.wang.advance.tasks.design.factory;

/**
 * Created by romantiskt on 2018/10/22.
 * 简单化的工厂方法   静态工厂模式
 */

public class InstanceSimpleFactory {

    public static  <T extends Phone> T createPhone(Class<T> c) {
        Phone phone=null;
        try {
            phone= (Phone) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) phone;
    }
}
