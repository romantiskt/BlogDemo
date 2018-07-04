package com.wang.advance.tasks.widget

import android.view.View
import butterknife.ButterKnife
import butterknife.OnClick
import com.wang.advance.R
import com.wang.advance.tasks.kotlin.base.BaseKotlinAct
import com.wang.advance.tasks.widget.enter.WidgetAllListAct

/**
 * Created by wangyang on 2018/7/4.下午8:51
 */
class WidgetMain : BaseKotlinAct() {
    override fun inflateLayoutId(): Any {
        return R.layout.act_widget_main
    }

    override fun afterInflateView() {
        super.afterInflateView()
        setUnBinder(ButterKnife.bind(this))
    }
    @OnClick(R.id.btn_low, R.id.btn_medium)
    fun click(view: View) {
        when (view.id) {
            R.id.btn_low -> {
                go(WidgetAllListAct::class.java)
            }
            R.id.btn_medium -> {

            }
        }
    }
}