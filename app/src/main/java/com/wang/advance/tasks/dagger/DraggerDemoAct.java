package com.wang.advance.tasks.dagger;

import android.view.View;

import com.wang.advance.R;
import com.wang.tools.base.BaseAct;
import com.wang.tools.common.LogUtils;

import javax.inject.Inject;

import butterknife.OnClick;

public class DraggerDemoAct extends BaseAct {

    @Inject
    Animal animal;

    @Override
    protected int getLayoutId() {
        return R.layout.act_dragger;
    }


    @OnClick({R.id.btn_inject})
    void click(View view){
        switch (view.getId()){
            case R.id.btn_inject:
                LogUtils.d(animal.toString());
                break;
        }
    }

    @Override
    protected void initDataAfterViewInflate() {
    }

    @Override
    protected void initView() {

    }

    @Override
    public String getClassTag() {
        return null;
    }
}
