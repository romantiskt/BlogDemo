package com.wang.advance.tasks.design.builder;

/**
 * Created by romantiskt on 2018/10/22.
 */

public class HuaWeiPhoneBuilder extends Builder {
    HuaWeiPhone phone=new HuaWeiPhone();
    @Override
    public Phone build() {
        phone.clear(23);
        phone.startUp(1000);
        return phone;
    }
}
