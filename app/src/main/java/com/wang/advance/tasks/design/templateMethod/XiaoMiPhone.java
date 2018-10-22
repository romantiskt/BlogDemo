package com.wang.advance.tasks.design.templateMethod;

/**
 * Created by romantiskt on 2018/10/22.
 */

public class XiaoMiPhone extends Phone {

    @Override
    protected void startApp(String name) {


    }

    @Override
    protected boolean checkAppInstall(String name) {
        return false;
    }

    @Override
    protected boolean checkAppSafe(String name) {
        return true;
    }

    @Override
    protected boolean isStartSafe() {
        return false;
    }
}
