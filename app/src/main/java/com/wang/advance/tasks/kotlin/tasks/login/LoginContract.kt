package com.wang.advance.tasks.kotlin.tasks.login

import com.wang.advance.tasks.kotlin.base.IBaseModel
import com.wang.advance.tasks.kotlin.base.IBasePresenter
import com.wang.advance.tasks.kotlin.base.IBaseView

/**
 * Created by wangyang on 2018/6/29.上午10:51
 */

class LoginContract {
    interface LoginView : IBaseView {
        fun enterMain()
    }

    interface LoginPresenter<V : IBaseView> : IBasePresenter<V> {
        fun loginForServer(phone: String, pwd: String)
    }

    interface LoginModel : IBaseModel {
        fun dologinApiCall()
    }
}