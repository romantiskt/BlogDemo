package com.wang.advance.model.touchview;

import android.view.View;
import android.widget.LinearLayout;

import com.wang.advance.R;
import com.wang.tools.base.BaseAct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 2017/9/12.
 */

public class TouchAct extends BaseAct {
    @Override
    protected void initData() {

    }

    LinearLayout mLlContainer;

    @Override
    protected void initView() {
        setContentView(R.layout.act_touch);
        mLlContainer= (LinearLayout) findViewById(R.id.ll_container);
        addView();
    }

    private void addView() {
        View inflate = View.inflate(this, R.layout.item_touch_views, null);
        mLlContainer.addView(inflate);
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
