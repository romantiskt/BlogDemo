package com.wang.advance.tasks.design.builder;

/**
 * Created by romantiskt on 2018/10/22.
 */

public class XiaoMiPhoneBuilder extends Builder {
    XiaoMiPhone phone=new XiaoMiPhone();

    @Override
    public Phone build() {
        phone.clear(63);
        phone.startUp(1000);
        return phone;
    }
}
