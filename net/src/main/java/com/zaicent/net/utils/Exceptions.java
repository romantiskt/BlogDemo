package com.zaicent.net.utils;/*
 * Exceptions.java
 * business
 * Created by wangyang on 2017/1/3.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */


/**
 * Created by wangyang
 * email: wyroman@163.com
 * projectName: instore
 */

public class Exceptions
{
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }


}
