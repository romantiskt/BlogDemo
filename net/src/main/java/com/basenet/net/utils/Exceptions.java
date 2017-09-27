package com.basenet.net.utils;

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
