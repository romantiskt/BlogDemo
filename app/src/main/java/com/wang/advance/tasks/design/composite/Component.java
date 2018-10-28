package com.wang.advance.tasks.design.composite;

import java.util.ArrayList;

/**
 * Created by romantiskt on 2018/10/28.
 * 组合模式 即把共有的抽象成高级别的类 然后让子类继承     这个模式也有点大众 是编程的常识
 * 所有模块公有属性
 */

public abstract class Component {

    public ArrayList filedList=new ArrayList();

    public abstract String getName();

    public abstract void invoke();

    public  void add(String filed){
        filedList.add(filed);
    }
}
