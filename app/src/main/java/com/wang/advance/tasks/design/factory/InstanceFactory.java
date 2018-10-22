package com.wang.advance.tasks.design.factory;

/**
 * Created by romantiskt on 2018/10/22.
 *
 */

public class InstanceFactory extends AbstractInstanceFactory {
    @Override
    public <T extends Phone> T createPhone(Class<T> c) {
        Phone phone=null;
        try {
            phone= (Phone) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) phone;
    }
}
