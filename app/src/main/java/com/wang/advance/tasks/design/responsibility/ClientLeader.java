package com.wang.advance.tasks.design.responsibility;

/**
 * Created by wangyang on 2018/10/26.下午5:37
 */
public class ClientLeader extends Leader {

    public ClientLeader() {
        super(10000);
    }

    @Override
    protected void replay() {
        System.out.println("我同意了你的请求。。"+getClass().getSimpleName());
    }
}
