package com.wang.advance.tasks.kotlin.entity.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.wang.advance.tasks.kotlin.base.BaseResponse
import com.wang.advance.tasks.kotlin.base.IBaseRequest

/**
 * Created by wangyang on 2018/6/29.下午4:46
 */
class LoginRequest(cmd: String, url: String) : IBaseRequest(cmd, url) {
    @Expose
    var phone: String? = null
}