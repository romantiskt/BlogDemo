package com.wang.advance.tasks.rn;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.wang.advance.tasks.rn.module.SpNativeModule;
import com.wang.advance.tasks.rn.module.ToastNativeModule;
import com.wang.advance.tasks.rn.view.ReactCircleViewManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 2018/5/30.上午10:52
 */
public class ReactPackageManager implements ReactPackage {
    /**
     * 原生view
     *
     * @param reactContext
     * @return
     */
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> views = new ArrayList<>();
        views.add(new ReactCircleViewManager());
        return views;
    }

    /**
     * 原生组件
     *
     * @param reactContext
     * @return
     */
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new SpNativeModule(reactContext));
        modules.add(new ToastNativeModule(reactContext));
        // Native 导航模块
        return modules;
    }
}
