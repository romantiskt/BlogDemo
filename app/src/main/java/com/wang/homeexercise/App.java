package com.wang.homeexercise;

import android.app.Application;

import com.wang.tools.common.LogUtils;

/**
 * Created by wangyang on 2017/03/03/
 * data:2017/3/3 ..time:14:55
 * email: wyroman@163.com
 * projectName: instore
 * 描述:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initPlugin();
    }

    private void initPlugin() {
        LogUtils.init("wang","woopra",true);
    }
}
