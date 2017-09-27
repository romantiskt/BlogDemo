package com.basenet.net.builder;


import com.basenet.net.request.OtherRequest;
import com.basenet.net.request.RequestCall;
import com.basenet.net.OkHttpUtils;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
