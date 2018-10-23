package com.wang.advance.tasks.design.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romantiskt on 2018/10/23.
 * 原型模式，
 * 在循环中重复创建同一个对象时使用：
 * 注意：
 * 1.clone构造函数不会执行
 * 2.深拷贝和浅拷贝
 */

public class Phone implements Cloneable{

    private String color;

    private List<String> arr=new ArrayList();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getArr() {
        return arr;
    }

    public void setArr(List<String> arr) {
        this.arr = arr;
    }

    @Override
    protected Phone clone() {//浅拷贝,arr对象类型的值不会被拷贝，会与拷贝之前对象可用同一内存地址
        Phone phone=null;
        try {
            phone= (Phone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return phone;
    }
}
