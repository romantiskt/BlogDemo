package com.wang.advance.tasks.kotlin.data.db

import android.content.Context
import com.wang.advance.tasks.kotlin.entity.db.DaoMaster
import org.greenrobot.greendao.database.Database

/**
 * Created by wangyang on 2018/6/29.下午4:17
 */
class DbOpenHelper(context: Context?, name: String?) : DaoMaster.OpenHelper(context, name) {
    override fun onUpgrade(db: Database?, oldVersion: Int, newVersion: Int) {
        super.onUpgrade(db, oldVersion, newVersion)
    }
}