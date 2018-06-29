package com.wang.advance.tasks.kotlin.data.db

import com.wang.advance.tasks.kotlin.entity.db.User
import io.reactivex.Observable

/**
 * Created by wangyang on 2018/6/29.下午4:09
 */
interface DbHelper {

    abstract fun insertUser(user: User): Observable<Long>?

    abstract fun getAllUsers(): Observable<List<User>>?
}