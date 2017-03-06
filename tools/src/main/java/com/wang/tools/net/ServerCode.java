/*
 * ServerCode.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */
package com.wang.tools.net;

/**
 * 网络接口响应Code.
 */
public interface ServerCode {

    /**
     * 服务器:接口访问成功
     */
    String SUCCESS = "success";

    /**
     * 服务器未登录
     */
    String NOLOGIN="nologin";
    /**
     * 服务器:接口访问失败
     */
    String ERRO = "error";

    /**
     * 服务器:接口访问失败,有给用户反馈的信息返回
     */
//    int FAILED_MESSAGE = 2;
//
//    /**
//     * 服务器:Token失效
//     */
//    int INVALID_TOKEN = 6;

    /**
     * 网络无连接
     */
    int NO_CONNECT = -100;

    /**
     * Json转换错误
     */
    int JSON_CONVERT_ERROR = -101;

    /**
     * 其他错误
     */
    int OTHER_NET_ERROR = -102;
    int TIME_OUT = -108;
    int CANCELED = -109;
}
