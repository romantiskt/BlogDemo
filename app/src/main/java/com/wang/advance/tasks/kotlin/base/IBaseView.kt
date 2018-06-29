package com.wang.advance.tasks.kotlin.base

import android.support.annotation.StringRes

/**
 * Created by wangyang on 2018/6/28.下午4:56
 */
interface IBaseView {
    abstract fun showLoading()

    abstract fun hideLoading()

    abstract fun onError(@StringRes resId: Int)

    abstract fun onError(message: String)

    abstract fun showMessage(message: String)

    abstract fun showMessage(@StringRes resId: Int)

    abstract fun isNetworkConnected(): Boolean

    abstract fun hideKeyboard()

}