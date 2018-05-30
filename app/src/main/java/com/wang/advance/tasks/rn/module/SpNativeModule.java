package com.wang.advance.tasks.rn.module;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.gson.Gson;
import com.wang.tools.common.SpUtil;

/**
 * Created by wangyang on 2018/5/30.上午11:05
 */
public class SpNativeModule extends ReactContextBaseJavaModule {
    public SpNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "Sp";
    }

    @ReactMethod
    public void putString(String key, String str) {
        SpUtil.getInstance().put(key, str);
    }

    @ReactMethod
    public void getString( String key,final Promise promise) {
        promise.resolve(SpUtil.getInstance().getString(key));
    }
}
