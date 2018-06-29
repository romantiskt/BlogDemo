package com.wang.advance.tasks.kotlin

import android.content.Context
import android.os.Bundle
import android.transition.TransitionManager.go
import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.wang.advance.R
import com.wang.advance.tasks.kotlin.base.BaseKotlinAct
import com.wang.advance.tasks.kotlin.tasks.login.LoginAct

/**
 * Created by wangyang on 2018/6/28.下午3:37
 */
 class KotlinAct : BaseKotlinAct() {
    override fun inflateLayoutId(): Any {
       return R.layout.activity_kotlin_main
    }

    override fun afterInflateView() {
        super.afterInflateView()
       setUnBinder(ButterKnife.bind(this))
    }

    @OnClick(R.id.tv_switch, R.id.tv_if, R.id.tv_recy,R.id.tv_login)
    fun onclick(view: View) {
        when (view.id) {
            R.id.tv_switch -> toast("hello world")
            R.id.tv_if -> {
                var time = System.currentTimeMillis()
                var result = if (time > System.currentTimeMillis()) 0 else 1
                logger("[if 可直接返回值]" + result.toString());
            }
            R.id.tv_recy -> {
                go(RecyAct::class.java)
            }
            R.id.tv_login->{
                go(LoginAct::class.java)
            }
            else -> {
                logger("no one is match")
            }
        }
    }

}