package com.wang.advance.tasks.kotlin.base

import com.wang.advance.tasks.kotlin.data.DataManager
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by wangyang on 2018/6/29.下午3:21
 */
open class BasePresenter<V : IBaseView, I : IBaseModel> : IBasePresenter<V> {
    internal var mCompositeDisposable: CompositeDisposable? = null
    internal var view: V? = null
    internal var model: I? = null

    constructor(model: I, mCompositeDisposable: CompositeDisposable) {
        this.mCompositeDisposable = mCompositeDisposable
        this.model = model
    }


    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        mCompositeDisposable?.dispose()
        view = null
    }

}