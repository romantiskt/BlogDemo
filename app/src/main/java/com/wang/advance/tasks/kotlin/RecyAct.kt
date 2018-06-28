package com.wang.advance.tasks.kotlin

import android.os.Bundle
import butterknife.ButterKnife
import butterknife.Unbinder
import com.wang.advance.R
import com.wang.advance.tasks.kotlin.base.BaseKotlinAct

/**
 * Created by wangyang on 2018/6/27.下午7:51
 */
class RecyAct : BaseKotlinAct() {
    var unBinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_recy)
        unBinder = ButterKnife.bind(this)

    }

    fun initData(): List<String> {
//        var list= listOf("1","2","3","4","5","6","7")//不可变集合
        val mutableList: MutableList<String> = mutableListOf<String>()//可变集合
        var i = 0
        while (i < 100) {
            mutableList.add("index_" + i++)
        }
        return mutableList
    }

    override fun onDestroy() {
        super.onDestroy()
        unBinder?.unbind()
    }
}