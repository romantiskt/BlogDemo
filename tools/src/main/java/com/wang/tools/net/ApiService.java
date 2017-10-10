package com.wang.tools.net;

import com.wang.tools.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wangyang on 2017/9/30.
 */

public class ApiService {
    private static String mBaseUrl;

    /**
     * 初始化BaseUrl
     */
    public static void setBaseUrl(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    /**
     * 构建OkHttp的对象
     */
    private static OkHttpClient.Builder okHttpBuilder() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        // 注意顺序,否者无法通过 LoggingInterceptor查看
        builder.addInterceptor(new HeaderInterceptor());

        if (BuildConfig.DEBUG) {
            // 网络请求Log信息
            HttpLoggingInterceptor loggerInterceptor = new HttpLoggingInterceptor();
            loggerInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggerInterceptor);
        }

        return builder;
    }

    /**
     * 获取 Retrofit Service
     *
     * @param serviceClazz Retrofit Api Service's Class
     * @return Retrofit Api Service Object
     */
    public static <T> T getApiService(Class<T> serviceClazz) {

        if (mBaseUrl == null) {
            throw new NullPointerException("retrofit's baseUrl is null, call method `ApiClient#setBaseUrl(String)` first!!!");
        }

        OkHttpClient okHttpClient = okHttpBuilder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(serviceClazz);
    }
}
