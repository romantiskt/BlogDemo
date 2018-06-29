package com.wang.advance.tasks.kotlin.base

/**
 * Created by wangyang on 2018/6/28.下午5:23
 */
interface IBasePresenter<V : IBaseView> {

    abstract fun onAttach(view: V)

    abstract fun onDetach()

}