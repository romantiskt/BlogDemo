package com.wang.advance.tasks.design.adapter;

import java.util.Map;

/**
 * Created by romantiskt on 2018/10/26.
 * 适配器模式  也可以当作 装饰器模式
 *
 *  当本地接口和需要对接的接口不同时  就可安排一个中间的适配器进行转换
 */

public class OutUserInfo extends OutUser {

    private Map baseInfo=super.getUserBaseUserInfo();
    private Map homeInfo=super.getUserHomeInfo();
    private Map officalInfo=super.getUserOfficalInfo();

    private String getHomeAddress(){

        return (String) this.homeInfo.get("address");
    }


    private String getName(){
        return (String) this.baseInfo.get("name");
    }

}
