/*
 * BaseRequest.java
 * business
 * Created by wangyang on 2017/1/6.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.net;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 服务端接口请求参数的基类.
 */
public class BaseRequest {

    protected String tag;

    private String token;

    @Expose
    private String url;

    /**
     * 请求体的Map集合
     */
    private Map<String, String> requestMap = new LinkedHashMap<>();

    /**
     * 将请求信息转换为json.
     *
     * @return 接口的关键信息
     */
    public String toJson() {
        // 只生成有expose注释的文件
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取请求<String,String>的Map集合
     */
    public Map<String, String> getRequestMap() {
        return getStringMap(this.getClass());
    }

    private Map<String, String> getStringMap(Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            SerializedName name = field.getAnnotation(SerializedName.class);
            if (name != null) {
                try {
                    field.setAccessible(true);
                    if (field.getType() == String.class && field.get(this) == null) {
                        // 当前注解上没有值，跳出继续循环
                        continue;
                    }
                    requestMap.put(name.value(), String.valueOf(field.get(this)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // 获取父类上的请求体集合
        Class superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            getStringMap(superClazz);
        }
        return requestMap;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
