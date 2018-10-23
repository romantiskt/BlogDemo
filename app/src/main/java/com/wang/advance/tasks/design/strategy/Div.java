package com.wang.advance.tasks.design.strategy;

/**
 * Created by wangyang on 2018/10/23.下午5:32
 */
public class Div implements Math {
    @Override
    public double calc(double paramA, double paramB) {
        return paramA/paramB;
    }
}
