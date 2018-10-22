package com.wang.advance.tasks.design.factory;

/**
 * Created by romantiskt on 2018/10/22.
 */

public abstract class AbstractInstanceFactory {
    public abstract <T extends Phone> T createPhone(Class<T> c);
}
