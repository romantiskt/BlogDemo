package com.wang.advance;

import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wang.advance.tasks.gl.OpenGLDemo;
import com.wang.advance.tasks.nativ.NativeTestAct;
import com.wang.advance.tasks.rn.MyReactActivity;
import com.wang.advance.tasks.rxjava.RxJavaDemoAct;
import com.wang.advance.tasks.widget.enter.WidgetAllListAct;
import com.wang.advance.tasks.widget.low.MultiLinesTextView;
import com.wang.tools.base.BaseAct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseAct {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    protected void initDataAfterViewInflate() {

    }

    @BindView(R.id.text2)
    MultiLinesTextView mTv;

    @Override
    protected void initView() {
        List<String> D = new ArrayList<>();
        D.add("Hello we are fjd fdfd fdj fjdjfj  ");
        D.add("World fdf ferfef erdfd ssfdfd  43434 43433333333333333333333333");
        mTv.setmDatas(D);
    }

    @OnClick({ R.id.btn_widget,R.id.btn_rxjava,R.id.btn_rn,R.id.btn_app_native,R.id.btn_native,R.id.btn_open_gl})
    void click(View view) {
        switch (view.getId()) {
            case R.id.btn_rn:
                startActivity(new Intent(this, MyReactActivity.class));
                break;
            case R.id.btn_widget:
                goAct(WidgetAllListAct.class);
                break;
            case R.id.btn_rxjava:
                goAct(RxJavaDemoAct.class);
                break;
            case R.id.btn_app_native:
                goAct(NativeActivity.class);
                break;
            case R.id.btn_native:
                goAct(NativeTestAct.class);
                break;
            case R.id.btn_open_gl:
                goAct(OpenGLDemo.class);
                break;
        }
    }

    @Override
    public String getClassTag() {
        return this.getClass().getSimpleName();
    }
}
