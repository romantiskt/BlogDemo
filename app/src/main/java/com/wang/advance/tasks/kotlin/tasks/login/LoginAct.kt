package com.wang.advance.tasks.kotlin.tasks.login

import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import com.wang.advance.R
import com.wang.advance.tasks.kotlin.base.BaseKotlinAct
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by wangyang on 2018/6/29.上午10:09
 */

class LoginAct : BaseKotlinAct(), LoginContract.LoginView {
    override fun enterMain() {
        toast("enter main")
    }

    var presenter:LoginPresenterImpl<LoginAct,LoginModelImpl>?= null
    override fun inflateLayoutId(): Any {
        return R.layout.act_login
    }

    override fun afterInflateView() {
        super.afterInflateView()
        setUnBinder(ButterKnife.bind(this))
        presenter=LoginPresenterImpl(LoginModelImpl(), CompositeDisposable())
        presenter?.onAttach(LoginAct@this)
    }


    @OnClick(R.id.btn_login)
    fun click(view:View){
        when(view.id){
            R.id.btn_login->{
                presenter?.loginForServer("1566666666","123456")
            }
        }
    }
}