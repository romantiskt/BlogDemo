package com.wang.advance.tasks.kotlin.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.wang.advance.tasks.kotlin.entity.AppConstants
import javax.inject.Inject

/**
 * Created by wangyang on 2018/6/29.下午3:54
 */
class AppPreferencesHelper :PreferencesHelper{
    private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
    private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"

    private var mPrefs: SharedPreferences?=null

    constructor( context:Context,
                 prefFileName:String) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }


    override fun getCurrentUserId(): Long? {
        val userId = mPrefs?.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
        return if (userId == AppConstants.NULL_INDEX) null else userId
    }

    override fun setCurrentUserId(userId: Long?) {
        val id = userId ?: AppConstants.NULL_INDEX
        mPrefs?.edit()?.putLong(PREF_KEY_CURRENT_USER_ID, id)?.apply()
    }

    override fun getAccessToken(): String? {
        return mPrefs?.getString(PREF_KEY_ACCESS_TOKEN, null)
    }

    override fun setAccessToken(accessToken: String) {
        mPrefs?.edit()?.putString(PREF_KEY_ACCESS_TOKEN, accessToken)?.apply()
    }
}