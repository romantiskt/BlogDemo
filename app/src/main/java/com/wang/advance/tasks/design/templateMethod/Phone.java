package com.wang.advance.tasks.design.templateMethod;

/**
 * Created by romantiskt on 2018/10/22.
 * 模板方法模式
 */

public abstract class Phone {

    protected abstract void startApp(String name);//启动一个app

    protected abstract boolean checkAppInstall(String name);//检查app是否安装

    protected abstract boolean checkAppSafe(String name);//检验app安全性

    protected abstract boolean isStartSafe();//是否开启安全模式

    protected void startUp(String name) {
        if (checkAppInstall(name)) {
            boolean safe = true;
            if (isStartSafe()) {
                safe = checkAppSafe(name);
            }

            if (safe) {
                startApp(name);
            }

        }
    }
}
