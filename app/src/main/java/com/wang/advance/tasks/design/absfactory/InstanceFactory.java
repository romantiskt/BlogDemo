package com.wang.advance.tasks.design.absfactory;

/**
 * Created by romantiskt on 2018/10/22.
 * 抽象工厂模式  即多工厂实现
 */

public interface InstanceFactory {
    public Phone createSdk28Phone();

    public Phone createSdk25Phone();

    public Phone createSdk23Phone();
}
