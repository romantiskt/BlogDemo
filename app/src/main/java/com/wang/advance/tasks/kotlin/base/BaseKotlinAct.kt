package com.wang.advance.tasks.kotlin.base

import android.app.Fragment
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import butterknife.Unbinder
import com.wang.advance.R
import com.wang.advance.tasks.kotlin.utils.ActUtil
import com.wang.advance.tasks.kotlin.utils.CommonUtils
import com.wang.advance.tasks.kotlin.utils.NetworkUtils
import javax.xml.datatype.Duration

/**
 * Created by wangyang on 2018/6/27.下午5:45
 */
abstract class BaseKotlinAct : AppCompatActivity(), IBaseView {
    var TAG: String = this.javaClass.simpleName
    internal var mUnBinder: Unbinder? = null
    internal var mProgressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeInflateView()
        val inflateLayoutId = inflateLayoutId()
        if (inflateLayoutId is Int) {
            setContentView(inflateLayoutId)
        } else if (inflateLayoutId is View) {
            //可对view进行一些公共的处理
            setContentView(inflateLayoutId)
        } else {
            throw RuntimeException("inflate is illegitmacy")
        }
        afterInflateView()
    }

    open fun beforeInflateView() {}
    open fun afterInflateView() {}
    abstract fun inflateLayoutId(): Any
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

    /**
     * 跳转
     */
    open fun <T> go(clazz: Class<T>) {
        ActUtil.go(this, clazz)
    }

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    override fun onDestroy() {
        mUnBinder?.unbind()
        super.onDestroy()
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (mProgressDialog?.isShowing == true) mProgressDialog?.cancel() else mProgressDialog = null
    }

    override fun onError(resId: Int) {
        onError(getString(resId))
    }

    override fun onError(message: String) {
        if (message != null) {
            showSnackBar(message)
        } else {
            showSnackBar(getString(R.string.some_error))
        }
    }

    fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.getView()
        val textView = sbView
                .findViewById(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.show()
    }

    override fun showMessage(message: String) {
        if (message != null) {
            toast(message)
        } else {
            toast(getString(R.string.some_error))
        }
    }

    override fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }

    /**
     * 拓展函数，会使Context及其所有子类拥有此方法
     */
    fun Context.log(message: String){
       logger(message)
    }

}