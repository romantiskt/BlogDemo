package com.wang.advance;

import android.app.Application;

import com.wang.advance.net.ApiConfigs;
import com.wang.tools.CommonEngine;
import com.wang.tools.net.ApiService;

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
        CommonEngine.init(this);
        ApiService.setBaseUrl(ApiConfigs.BASE_URL);
    }
}
