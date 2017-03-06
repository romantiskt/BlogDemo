/*
 * BizErrorInfo.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.net;


/**
 * 网络业务错误信息类.
 */
public class BizErrorInfo {

    private String message;

    private String code;

    /**
     * 服务端响应的信息.
     */
    private BaseResponse response;

    public BizErrorInfo(String code, String message, BaseResponse response) {
        this.message = message;
        this.code = code;
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BaseResponse getResponse() {
        return response;
    }

    public void setResponse(BaseResponse response) {
        this.response = response;
    }


}
