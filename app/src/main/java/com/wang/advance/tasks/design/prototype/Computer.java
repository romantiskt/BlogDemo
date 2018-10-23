package com.wang.advance.tasks.design.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romantiskt on 2018/10/23.
 */

public class Computer implements Cloneable {
    private String color;

    private ArrayList<String> arr=new ArrayList();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<String> getArr() {
        return arr;
    }

    public void setArr(ArrayList<String> arr) {
        this.arr = arr;
    }

    @Override
    protected Computer clone() {//深拷贝，需要将对象类型常量单独处理   注意：如果变量用final关键字修饰，则不可拷贝
        Computer computer=null;
        try {
            computer= (Computer) super.clone();
            computer.arr= (ArrayList<String>) this.arr.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return computer;
    }
}
