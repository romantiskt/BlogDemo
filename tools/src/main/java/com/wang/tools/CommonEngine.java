package com.wang.tools;

import android.content.Context;
import android.support.annotation.NonNull;

import com.wang.tools.common.LogUtils;
import com.wang.tools.common.SingleToast;

/**
 * Created by wangyang on 2017/03/06/
 * data:2017/3/6 ..time:16:12
 * email: wyroman@163.com
 * 描述:
 */
public class CommonEngine implements IEnterInit{
    private static final String TAG="CommonEngine";

   public static CommonEngine mCommonEngine;
    public static Context mContext;

    public CommonEngine(Context context) {
        mContext = context;
        initLog();
        initToast();
        initNet();
    }

    public static void init(@NonNull Context context) {
        if (mCommonEngine == null) {
            synchronized (CommonEngine.class) {
                if (mCommonEngine == null) {
                    mCommonEngine = new CommonEngine(context);
                }
            }
        }
    }

    /**
     * 初始化log
     */
    @Override
    public void initLog() {
        LogUtils.init("wang","woopra",true);
    }

    /**|
     * 初始化toast
     */
    @Override
    public void initToast() {
        SingleToast.init(mContext);
    }

    /**
     * 初始化网络
     */
    @Override
    public void initNet() {

    }

    public static Context getContext() {
        return mContext;
    }

//    public static CommonEngine getmCommonEngine() {
//        if(mCommonEngine==null){
//            throw new RuntimeException(TAG+"you should init CommonEngine in Application");
//        }
//        return mCommonEngine;
//    }

}
