package com.wang.advance.tasks.kotlin.data.api

import com.wang.advance.tasks.kotlin.base.IBaseRequest
import com.wang.advance.tasks.kotlin.entity.request.LoginRequest

/**
 * Created by wangyang on 2018/6/29.下午4:42
 */
interface ApiHelper {
     fun doGetConfigApiCall(request: IBaseRequest)
}