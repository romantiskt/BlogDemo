package com.wang.advance.tasks.kotlin.base

import android.util.Log

/**
 * Created by wangyang on 2018/6/29.下午5:58
 */
open class BaseModel : IBaseModel {
    private val TAG = javaClass.simpleName
    fun log(msg: String) {
        Log.d(TAG, msg)
    }
}