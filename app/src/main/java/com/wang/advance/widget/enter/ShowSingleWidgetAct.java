package com.wang.advance.widget.enter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.wang.advance.R;
import com.wang.advance.widget.AnnularView;
import com.wang.advance.widget.BrickView;
import com.wang.advance.widget.CustomView1;
import com.wang.advance.widget.CustomView2;
import com.wang.advance.widget.CustomView3;
import com.wang.advance.widget.CustomView4;
import com.wang.advance.widget.CustomView5;
import com.wang.advance.widget.CustomView6;
import com.wang.advance.widget.MatrixImageView;
import com.wang.advance.widget.MultiCricleView;
import com.wang.advance.widget.ShaderView;
import com.wang.tools.base.BaseAct;
import com.wang.tools.common.UIUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by romantiskt on 2017/3/9.
 */

public class ShowSingleWidgetAct extends BaseAct {
    public static final String EXA_SHOW_TYPE = "exa_show_type";

    @Override
    protected void initData() {

    }

    RelativeLayout mRlParent;

    @Override
    protected void initView() {
        setContentView(R.layout.act_widget_show);
        mRlParent = (RelativeLayout) findViewById(R.id.rl_parent);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra(EXA_SHOW_TYPE);
            ViewType viewType = ViewType.fromTypeName(stringExtra);
            switch (viewType) {
                case AnnularView:
                    AnnularView annularView = new AnnularView(this);
                    annularView.setSourceData(new float[]{40, 50, 110}, new String[]{"苹果", "香蕉", "梨子"});
                    addViewToContainer(annularView);
                    break;
                case BrickView:
                    addViewToContainer(new BrickView(this));
                    break;
                case CustomView1:
                    addViewToContainer(new CustomView1(this));
                    break;
                case CustomView2:
                    addViewToContainer(new CustomView2(this));
                    break;
                case CustomView3:
                    addViewToContainer(new CustomView3(this));
                    break;
                case CustomView4:
                    addViewToContainer(new CustomView4(this));
                    break;
                case CustomView5:
                    addViewToContainer(new CustomView5(this));
                    break;
                case CustomView6:
                    addViewToContainer(new CustomView6(this));
                    break;
                case MatrixImageView:
                    addViewToContainer(new MatrixImageView(this));
                    break;
                case MultiCricleView:
                    addViewToContainer( new MultiCricleView(this));
                    break;
                case ShaderView:
                    addViewToContainer(new ShaderView(this));
                    break;
            }
        }
    }

    private void addViewToContainer(View view) {
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mRlParent.addView(view);
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
