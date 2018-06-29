package com.wang.advance.tasks.kotlin.tasks.login

import com.wang.advance.tasks.kotlin.base.BasePresenter
import com.wang.advance.tasks.kotlin.base.IBaseModel
import com.wang.advance.tasks.kotlin.data.DataManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by wangyang on 2018/6/29.上午10:15
 */

class LoginPresenterImpl<V : LoginContract.LoginView,I:LoginContract.LoginModel>(model: I, mCompositeDisposable: CompositeDisposable)
    : BasePresenter<V,I>(model, mCompositeDisposable), LoginContract.LoginPresenter<V> {
    override fun loginForServer(phone: String, pwd: String) {
        this.view?.showLoading()
        this.model?.dologinApiCall()
        this.mCompositeDisposable
                ?.add(Observable.timer(2, TimeUnit.SECONDS)
                                .observeOn(AndroidSchedulers.mainThread())
                                 .subscribeOn(Schedulers.io())
                                .subscribe(Consumer {
                                        view?.hideLoading()
                                        view?.enterMain()
                        }))

    }
}