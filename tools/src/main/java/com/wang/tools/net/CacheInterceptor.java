
package com.wang.tools.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.wang.tools.CommonEngine;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wangyang on 2016/9/19.
 * data:2016/9/19 ..time:14:26
 * email: wyroman@163.com
 * 描述:
 */
public class CacheInterceptor implements Interceptor {

    /**
     * 判断网络是否可用
     *
     */
    public static Boolean isNetworkReachable() {
        ConnectivityManager cm = (ConnectivityManager) CommonEngine.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }
    @Override
    public Response intercept(Chain chain) throws IOException {

        int maxAge = 60*60; // 有网络时 设置缓存超时时间1个小时
        int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
        Request request = chain.request();
        final Boolean networkReachable = isNetworkReachable();
        if (networkReachable) {
            request= request.newBuilder()
//                    .addHeader("apikey", "2ffc3e48c7086e0e1faa003d781c0e69")
                    .cacheControl(CacheControl.FORCE_NETWORK)//有网络时只从网络获取
                    .build();
        }else {
            request= request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)//无网络时只从缓存中读取
                    .build();
        }
        Response response = chain.proceed(request);
        if (networkReachable) {
            response= response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            response= response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return response;
    }
}
