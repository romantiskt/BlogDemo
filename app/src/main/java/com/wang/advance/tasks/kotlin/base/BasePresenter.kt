package com.wang.advance.tasks.kotlin.base

/**
 * Created by wangyang on 2018/6/28.下午5:23
 */
interface BasePresenter<V : BaseView> {

    abstract fun onAttach(mvpView: V)

    abstract fun onDetach()

    abstract fun setUserAsLoggedOut()
}