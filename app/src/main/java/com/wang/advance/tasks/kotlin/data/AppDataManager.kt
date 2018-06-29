package com.wang.advance.tasks.kotlin.data

import android.content.Context
import com.wang.advance.tasks.kotlin.base.IBaseRequest
import com.wang.advance.tasks.kotlin.data.api.ApiHelper
import com.wang.advance.tasks.kotlin.data.db.DbHelper
import com.wang.advance.tasks.kotlin.data.prefs.PreferencesHelper
import com.wang.advance.tasks.kotlin.entity.db.User
import com.wang.advance.tasks.kotlin.entity.request.LoginRequest
import io.reactivex.Observable

/**
 * Created by wangyang on 2018/6/29.下午4:51
 */
class AppDataManager : DataManager {
    internal var mContext: Context? = null
    internal var mDbHelper: DbHelper? = null
    internal var mPreferencesHelper: PreferencesHelper? = null
    internal var mApiHelper: ApiHelper? = null

    constructor(mContext: Context?, mDbHelper: DbHelper?, mPreferencesHelper: PreferencesHelper?, mApiHelper: ApiHelper?) {
        this.mContext = mContext
        this.mDbHelper = mDbHelper
        this.mPreferencesHelper = mPreferencesHelper
        this.mApiHelper = mApiHelper
    }

    override fun doGetConfigApiCall(request: IBaseRequest) {
        mApiHelper?.doGetConfigApiCall(request)
    }

    override fun getAllUsers(): Observable<List<User>>? {
        return mDbHelper?.getAllUsers()
    }

    override fun getCurrentUserId(): Long? {
        return mPreferencesHelper?.getCurrentUserId()
    }

    override fun setCurrentUserId(userId: Long?) {
        mPreferencesHelper?.setCurrentUserId(userId)
    }

    override fun getAccessToken(): String? {
        return mPreferencesHelper?.getAccessToken()
    }

    override fun setAccessToken(accessToken: String) {
        mPreferencesHelper?.setAccessToken(accessToken)
    }

    override fun insertUser(user: User): Observable<Long>? {
        return mDbHelper?.insertUser(user)
    }
}