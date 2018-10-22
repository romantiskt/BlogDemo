package com.wang.advance.tasks.design.absfactory;

/**
 * Created by romantiskt on 2018/10/22.
 */

public class InstanceXiaoMiFactory implements InstanceFactory {
    @Override
    public Phone createSdk28Phone() {
        return null;
    }

    @Override
    public Phone createSdk25Phone() {
        return new XiaoMi25Phone();
    }

    @Override
    public Phone createSdk23Phone() {
        return null;
    }
}
