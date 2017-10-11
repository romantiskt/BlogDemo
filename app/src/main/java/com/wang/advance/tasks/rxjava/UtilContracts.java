package com.wang.advance.tasks.rxjava;

import android.widget.TextView;

/**
 * Created by wangyang on 2017/10/11.
 */

public abstract class UtilContracts {
    protected final String TAG = this.getClass().getCanonicalName();
    public static final String LINE_SEPARATOR = "\n";

    public abstract void util(TextView tv);
}
