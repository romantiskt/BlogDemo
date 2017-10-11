package com.wang.advance.tasks.rxjava;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wang.advance.R;
import com.wang.advance.tasks.rxjava.operators.CommonUtil;
import com.wang.advance.tasks.rxjava.operators.DisposUtil;
import com.wang.advance.tasks.rxjava.operators.MapUtil;
import com.wang.advance.tasks.rxjava.operators.ZipUtil;
import com.wang.advance.tasks.widget.low.dialog.ListDialog;
import com.wang.tools.base.BaseAct;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wangyang on 2017/10/10.
 */

public class RxJavaDemoAct extends BaseAct {
    @Override
    protected int getLayoutId() {
        return R.layout.act_rxjava_demo;
    }

    String[] datas = new String[]{
            "Common", "Map", "Zip", "Disposable"
    };

    @Override
    protected void initDataAfterViewInflate() {
    }

    @BindView(R.id.btn_select)
    Button mBtnSelect;
    @BindView(R.id.tv_show)
    TextView mTvShow;

    @OnClick({R.id.btn_select})
    void click(View view) {
        switch (view.getId()) {
            case R.id.btn_select:
                ListDialog listDialog = new ListDialog(this, Arrays.asList(datas));
                listDialog.setOnSelectedListener(mOnSelectedListener);
                listDialog.show();
                break;
        }
    }

    ListDialog.OnSelectedListener mOnSelectedListener = new ListDialog.OnSelectedListener() {
        @Override
        public void clickPos(int pos) {
            String mark = (String) datas[pos];
            switch (mark) {
                case "Common":
                    new CommonUtil().util(mTvShow);
                    break;
                case "Map":
                    new MapUtil().util(mTvShow);
                    break;
                case "Zip":
                    new ZipUtil().util(mTvShow);
                    break;
                case "Disposable":
                    new DisposUtil().util(mTvShow);
                    break;


            }
        }
    };

    @Override
    protected void initView() {

    }

    @Override
    public String getClassTag() {
        return getClass().getSimpleName();
    }
}
