package com.wang.advance.tasks.design.absfactory;

/**
 * Created by romantiskt on 2018/10/22.
 */

public class InstanceHuaWeiFactory implements InstanceFactory {
    @Override
    public Phone createSdk28Phone() {
        return new HuaWei28Phone();
    }

    @Override
    public Phone createSdk25Phone() {
        return null;
    }

    @Override
    public Phone createSdk23Phone() {
        return new HuaWei23Phone();
    }
}
