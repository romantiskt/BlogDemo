package com.wang.tools.nativedemo;

/**
 * Created by wangyang on 2018/6/4.上午9:47
 */
public class TaskNativeUtil {


    static {
        System.loadLibrary("hello-jnicallback");
    }

    public native static String stringFromJNI();

    public native void startTicks();

    public native void StopTicks();
}
