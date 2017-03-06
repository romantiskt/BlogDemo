/*
 * OtherRequestBuilder.java
 * business
 * Created by wangyang on 2017/1/3.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.zaicent.net.builder;


import com.zaicent.net.request.OtherRequest;
import com.zaicent.net.request.RequestCall;

import okhttp3.RequestBody;

/**
 * DELETE、PUT、PATCH等其他方法
 */
public class OtherRequestBuilder extends OkHttpRequestBuilder<OtherRequestBuilder>
{
    private RequestBody requestBody;
    private String method;
    private String content;

    public OtherRequestBuilder(String method)
    {
        this.method = method;
    }

    @Override
    public RequestCall build()
    {
        return new OtherRequest(requestBody, content, method, url, tag, params, headers,id).build();
    }

    public OtherRequestBuilder requestBody(RequestBody requestBody)
    {
        this.requestBody = requestBody;
        return this;
    }

    public OtherRequestBuilder requestBody(String content)
    {
        this.content = content;
        return this;
    }


}
