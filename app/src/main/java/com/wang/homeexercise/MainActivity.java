package com.wang.homeexercise;

import android.os.Bundle;

import com.wang.homeexercise.smoothlist.adapter.DividerAdapter;
import com.wang.tools.base.BaseAct;

import java.util.List;

public class MainActivity extends BaseAct {
    List<String> mData;
    DividerAdapter mDividerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);

    }

    @Override
    public String getClassTag() {
        return null;
    }
}
