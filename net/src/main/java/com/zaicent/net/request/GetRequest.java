package com.zaicent.net.request;/*
 * GetRequest.java
 * business
 * Created by wangyang on 2017/1/3.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */


import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by zhy on 15/12/14.
 */
public class GetRequest extends OkHttpRequest
{
    public GetRequest(String url, Object tag, Map<String, String> params, Map<String, String> headers,int id)
    {
        super(url, tag, params, headers,id);
    }

    @Override
    protected RequestBody buildRequestBody()
    {
        return null;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody)
    {
        return  builder.get().build();
    }


}
