package com.wang.advance.tasks.kotlin.data

import com.wang.advance.tasks.kotlin.data.api.ApiHelper
import com.wang.advance.tasks.kotlin.data.db.DbHelper
import com.wang.advance.tasks.kotlin.data.prefs.PreferencesHelper

/**
 * Created by wangyang on 2018/6/29.下午4:23
 */
interface DataManager:DbHelper,PreferencesHelper,ApiHelper {
    //中间池 可做一些特殊的事
}