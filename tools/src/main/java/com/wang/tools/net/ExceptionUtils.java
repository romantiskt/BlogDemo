/*
 * ExceptionUtils.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.net;

import android.text.TextUtils;

/**
 * 异常工具.
 */
public final class ExceptionUtils {

    /**
     * TAG.
     */
    public static final String TAG = "ExceptionUtils";

    /**
     * 往异常的堆栈中添加信息的位置.
     */
    public enum PositionEnum {
        TOP, BOTTOM
    }

    /**
     * 异常工具.
     */
    private ExceptionUtils() {
    }

    /**
     * 在异常的堆栈的顶部添加信息.
     *
     * @param e 异常
     * @param clazz 发生异常的类信息
     * @param message 添加的信息
     */
    public static void addMessage(Exception e, Class clazz, String message) {
        addMessage(e, clazz, message, PositionEnum.TOP);
    }

    /**
     * 在异常的堆栈中添加信息.
     *
     * @param e 异常
     * @param clazz 发生异常的类信息
     * @param message 添加的信息
     * @param position 信息在异常的堆栈中添加的位置
     */
    public static void addMessage(Exception e, Class clazz, String message, PositionEnum position) {
        if (e == null) {
            throw new NullPointerException("e不能为空");
        } else if (clazz == null) {
            throw new NullPointerException("clazz不能为空");
        } else if (TextUtils.isEmpty(message)) {
            throw new NullPointerException("message不能为空");
        } else if (position == null) {
            throw new NullPointerException("position不能为空");
        }
        StackTraceElement[] elements =  e.getStackTrace();
        StackTraceElement[] extraElements = new StackTraceElement[elements.length + 1];
        StackTraceElement element = new StackTraceElement(clazz.getCanonicalName(), "Context messages", message, -1);
        switch (position) {
            case TOP:
                /* 在栈顶添加额外信息 */
                System.arraycopy(elements, 0, extraElements, 1, elements.length);
                extraElements[0] = element;
                break;
            case BOTTOM:
                /* 在栈底添加额外信息 */
                System.arraycopy(elements, 0, extraElements, 0, elements.length);
                extraElements[elements.length] = element;
                break;
        }
        e.setStackTrace(extraElements);
    }
}
