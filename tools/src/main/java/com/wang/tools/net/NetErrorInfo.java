/*
 * NetErrorInfo.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.net;

/**
 * 网络错误信息类.
 */
public class NetErrorInfo {

    private String message;

    private int code;

    private Exception exception;

    public NetErrorInfo(String message, int code, Exception exception) {
        this.message = message;
        this.code = code;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
