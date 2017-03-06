/*
 * BaseResponse.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.net;


import com.wang.tools.common.GsonUtil;

/**
 * 响应的基类.
 */
public class BaseResponse {
    /**
     * result : success
     * resultMsg : 成功
     * resultCode : 00000-00000-0000
     * data : {}
     */

    private String result;
    private String resultMsg;
    private String resultCode;

    public String toJson() {
        return GsonUtil.GsonString(this);
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

}
