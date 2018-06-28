package com.wang.advance.tasks.kotlin.utils

import android.content.Context
import android.content.Intent

/**
 * Created by wangyang on 2018/6/28.下午3:54
 */

 object ActUtil{

    @JvmStatic fun <T> go(context: Context, clazz: Class<T>) {
        var intent = Intent(context, clazz)
        context.startActivity(intent)
    }

}