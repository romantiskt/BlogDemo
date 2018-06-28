package com.wang.advance.tasks.kotlin.base

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.wang.advance.tasks.kotlin.utils.ActUtil

/**
 * Created by wangyang on 2018/6/27.下午5:45
 */
open class BaseKotlinAct : AppCompatActivity() {
    var TAG: String = this.javaClass.simpleName
    /**
     * toast.("hello")
     * toast.("hello",Toast.LENGTH_SHORT)
     * toast.(msg="hello",length=Toast.LENGTH_SHORT)
     */
    fun toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, length).show()
    }

    /**
     * 返回一个参数
     */
    fun isAdd(fragment: Fragment): Boolean {
        return fragment.isAdded
    }

    /**
     * 使用string 模板拼凑string
     */
    fun logger(msg: String, tag: String = this.javaClass.simpleName) {
        Log.d(tag, "[$tag]  $msg")
    }

    open fun <T> go(clazz: Class<T>) {
        ActUtil.go(this,clazz)
    }


}