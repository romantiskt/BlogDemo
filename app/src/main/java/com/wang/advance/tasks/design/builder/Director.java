package com.wang.advance.tasks.design.builder;

/**
 * Created by romantiskt on 2018/10/22.
 */

public class Director {

    public Phone getMiPhone(){
        return  new XiaoMiPhoneBuilder().build();
    }

    public Phone getHuaWeiPhone(){
        return new HuaWeiPhoneBuilder().build();
    }
}
