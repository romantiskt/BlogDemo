/*
 * L.java
 * business
 * Created by wangyang on 2017/1/3.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.zaicent.net.utils;

import android.util.Log;

/**
 * Created by zhy on 15/11/6.
 */
public class L
{
    private static boolean debug = false;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("OkHttp", msg);
        }
    }

}

