package com.wang.advance.tasks.kotlin.data.prefs

/**
 * Created by wangyang on 2018/6/29.下午3:54
 */
interface PreferencesHelper {

    abstract fun getCurrentUserId(): Long?

    abstract fun setCurrentUserId(userId: Long?)

    abstract fun getAccessToken(): String?

    abstract fun setAccessToken(accessToken: String)
}