/*
 * PostFileBuilder.java
 * business
 * Created by wangyang on 2017/1/3.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.zaicent.net.builder;


import com.zaicent.net.request.PostFileRequest;
import com.zaicent.net.request.RequestCall;

import java.io.File;

import okhttp3.MediaType;

/**
 * Created by zhy on 15/12/14.
 */
public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder>
{
    private File file;
    private MediaType mediaType;


    public OkHttpRequestBuilder file(File file)
    {
        this.file = file;
        return this;
    }

    public OkHttpRequestBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostFileRequest(url, tag, params, headers, file, mediaType,id).build();
    }


}
