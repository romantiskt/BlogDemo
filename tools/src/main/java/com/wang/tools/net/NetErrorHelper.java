/*
 * NetErrorHelper.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.net;

import android.text.TextUtils;

import com.google.gson.JsonParseException;
import com.wang.tools.R;
import com.wang.tools.common.LogUtils;
import com.wang.tools.common.UIUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * 网络错误帮助类.
 */
public class NetErrorHelper {

    /**
     * 网络错误的封装
     */
    public static NetErrorInfo generateNetErrorInfo(final Exception exception) {

        int code;
        String message = null;

        boolean networkAvailable = NetworkUtils.isNetworkAvailable(UIUtils.getContext());

        // 网络错误封装
        if (!networkAvailable) {
            // 网络无连接 --->  检查网络
            code = ServerCode.NO_CONNECT;
            message = UIUtils.getString(R.string.net_no_connect);
        } else if (exception instanceof JsonParseException) {
            // Json转换错误  --> 上传至友盟 包含Request --> Json
            code = ServerCode.JSON_CONVERT_ERROR;
            message = UIUtils.getString(R.string.parse_error);
        } else if (exception instanceof SocketTimeoutException) {
            // 连接超时
            code = ServerCode.TIME_OUT;
            message = UIUtils.getString(R.string.net_time_out);
        } else if (exception instanceof IOException) {
            if ("Canceled".equals(exception.getMessage()) || "Socket closed".equals(exception.getMessage())) {
                code = ServerCode.CANCELED;
                message = null;
            } else {
                code = ServerCode.OTHER_NET_ERROR;
                message = UIUtils.getString(R.string.net_error);
            }
        } else {
            // 其他错误
            code = ServerCode.OTHER_NET_ERROR;
            message = UIUtils.getString(R.string.net_error);
        }
        NetErrorInfo errorInfo = new NetErrorInfo(message, code, exception);
        return errorInfo;
    }

    /**
     * 报告网络错误, 在前台打印日志信息, 远程通过友盟上传错误日志.
     */
    public static void reportError(final Class clazz, final String url, final BaseRequest request, final NetErrorInfo netErrorInfo, String responseBody) {
        if (clazz == null || TextUtils.isEmpty(url) || request == null || netErrorInfo == null) {
            return;
        }

        String content = null;
        int code = netErrorInfo.getCode();
        Exception exception = netErrorInfo.getException();
        if (TextUtils.isEmpty(responseBody)) {
            responseBody = "服务器无响应信息";
        }

        switch (code) {
            case ServerCode.NO_CONNECT:
                // 网络无连接
                content = "网络无连接_"+netErrorInfo.getMessage();
                break;
            case ServerCode.JSON_CONVERT_ERROR:
                // Json转换错误 --> 上传至友盟
                content = "服务端响应结果解析异常, url : " + url + "\n请求参数 : " + request.toJson()
                        + "\n响应结果 : " + responseBody;
                ExceptionUtils.addMessage(exception, clazz, "Response-Result : " + responseBody);
                ExceptionUtils.addMessage(exception, clazz, "Request-Params : " + request.toJson());
                ExceptionUtils.addMessage(exception, clazz, "Server-ParserError, url : " + url);
//                MobclickAgent.reportError(UIUtils.getContext(), exception);
//                CrashReport.postCatchedException(exception);
                break;
            case ServerCode.OTHER_NET_ERROR:
                // 其他错误
                content = "其他异常, url : " + url;
                break;
        }

        // 前台打印错误信息
        LogUtils.n(content+"_exception_"+exception);
    }
}
