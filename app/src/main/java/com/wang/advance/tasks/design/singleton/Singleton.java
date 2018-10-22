package com.wang.advance.tasks.design.singleton;

/**
 * Created by romantiskt on 2018/10/22.
 *
 * 单例常见的通用代码(饿汉式)
 */

public class Singleton {
    public static final Singleton singleton=new Singleton();

    private Singleton(){}

    public static Singleton getSingleton(){
        return singleton;
    }
}



