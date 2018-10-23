package com.wang.advance.tasks.design.strategy;

/**
 * Created by wangyang on 2018/10/23.下午5:30
 * 加法
 */
public class Add implements Math {
    @Override
    public double calc(double paramA, double paramB) {
        return paramA+paramB;
    }
}
