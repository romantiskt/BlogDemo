package com.wang.advance.tasks.kotlin.tasks.login

import com.wang.advance.tasks.kotlin.base.BaseModel

/**
 * Created by wangyang on 2018/6/29.下午5:54
 */
class LoginModelImpl : BaseModel(), LoginContract.LoginModel {
    override fun dologinApiCall() {
        log("------login-------")
    }
}