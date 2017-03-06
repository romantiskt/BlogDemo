/*
 * DownloadListener.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.net;


import java.io.File;

/**
 * 文件下载的接口回掉.
 */
public interface DownloadListener {

    void onSuccess(File file);

    boolean onError(NetErrorInfo netErrorInfo);

    void onFinal();
}
