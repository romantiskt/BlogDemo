package com.wang.tools.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wang.tools.common.ActivityTasks;
import com.wang.tools.common.LogUtils;

import butterknife.ButterKnife;

/**
 * Created by wangyang on 2017/03/03/
 * data:2017/3/3 ..time:14:35
 * email: wyroman@163.com
 * projectName: instore
 * 描述:
 */
public abstract class BaseAct extends AppCompatActivity {


    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(getClassTag() + "-----onStart()-----");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d(getClassTag() + "-----onStop()-----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityTasks.removeActivity(this);
        LogUtils.d(getClassTag() + "-----onDestroy()-----");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initDataAfterViewInflate();
    }

    protected abstract int getLayoutId() ;

    protected abstract void initDataAfterViewInflate();

    protected abstract void initView();

    public abstract String getClassTag();
}
