package com.wang.advance.tasks.kotlin.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by wangyang on 2018/6/29.下午3:37
 */
open class IBaseRequest (
        @Expose
        @SerializedName("cmd")
        var cmd:String,
        var url:String
)