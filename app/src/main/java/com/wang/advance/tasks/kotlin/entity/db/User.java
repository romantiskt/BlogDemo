package com.wang.advance.tasks.kotlin.entity.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wangyang on 2018/6/29.下午4:39
 */
@Entity
public class User {
    String name;

    @Generated(hash = 422536127)
    public User(String name) {
        this.name = name;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
