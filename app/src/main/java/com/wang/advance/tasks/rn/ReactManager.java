package com.wang.advance.tasks.rn;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.wang.advance.App;
import com.wang.advance.BuildConfig;

/**
 * Created by wangyang on 2018/5/30.上午10:42
 */
public class ReactManager {

    private volatile static ReactInstanceManager mReactInstanceManager;

    private ReactManager() {
    }

    /**
     * app全局只允许一个manage
     * @return
     */
    public static ReactInstanceManager getInstance() {
        if (mReactInstanceManager == null) {
            synchronized (ReactManager.class) {
                if (mReactInstanceManager == null) {
                    mReactInstanceManager = ReactInstanceManager.builder()
                            .setApplication(App.getInstance())
                            .setBundleAssetName("index.android.bundle")
//                            .setJSMainModulePath("index")
                            .addPackage(new MainReactPackage())
                            .addPackage(new ReactPackageManager())
                            .setUseDeveloperSupport(BuildConfig.DEBUG)
                            .setInitialLifecycleState(LifecycleState.RESUMED)
                            .build();
                }
            }
        }
        return mReactInstanceManager;
    }
}
