package com.wang.tools.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wangyang on 2017/9/30.
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {

        Request.Builder builder = chain.request()
                .newBuilder()
                .addHeader("header-key", "header-value");

        return chain.proceed(builder.build());
    }
}