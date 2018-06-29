package com.wang.advance.tasks.kotlin.data.db

import com.wang.advance.tasks.kotlin.entity.db.DaoMaster
import com.wang.advance.tasks.kotlin.entity.db.DaoSession
import com.wang.advance.tasks.kotlin.entity.db.User
import io.reactivex.Observable
import java.util.concurrent.Callable
import javax.inject.Inject

/**
 * Created by wangyang on 2018/6/29.下午5:30
 */
class AppDbHelper:DbHelper{
     var mDaoSession: DaoSession?=null

    constructor(dbOpenHelper: DbOpenHelper) {
        mDaoSession = DaoMaster(dbOpenHelper.writableDb).newSession()
    }
    override fun insertUser(user: User): Observable<Long>? {
        return Observable.fromCallable(Callable { mDaoSession?.userDao?.insert(user) })
    }

    override fun getAllUsers(): Observable<List<User>>? {
    return  Observable.fromCallable(Callable { mDaoSession?.userDao?.loadAll() })
    }
}