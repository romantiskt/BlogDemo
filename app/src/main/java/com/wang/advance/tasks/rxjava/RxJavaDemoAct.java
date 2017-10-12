package com.wang.advance.tasks.rxjava;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wang.advance.R;
import com.wang.advance.tasks.rxjava.operators.BufferUtil;
import com.wang.advance.tasks.rxjava.operators.CommonUtil;
import com.wang.advance.tasks.rxjava.operators.CompletableUtil;
import com.wang.advance.tasks.rxjava.operators.DisposUtil;
import com.wang.advance.tasks.rxjava.operators.DisposableUtil;
import com.wang.advance.tasks.rxjava.operators.FilterUtil;
import com.wang.advance.tasks.rxjava.operators.IntervalUtil;
import com.wang.advance.tasks.rxjava.operators.MapUtil;
import com.wang.advance.tasks.rxjava.operators.ReduceUtil;
import com.wang.advance.tasks.rxjava.operators.ScanUtil;
import com.wang.advance.tasks.rxjava.operators.SingleUtil;
import com.wang.advance.tasks.rxjava.operators.SkipUtil;
import com.wang.advance.tasks.rxjava.operators.SubjectUtil;
import com.wang.advance.tasks.rxjava.operators.TakeUtil;
import com.wang.advance.tasks.rxjava.operators.TimerUtil;
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
            "Common", "Map", "Zip", "Disposable", "Disposable管理", "Take",
            "Timer", "Interval", "Single", "Completable", "Reduce","Buffer",
            "Filter","Skip","Scan","Subject"
    };
    UtilContracts utilContracts;

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
                case "Disposable管理":
                    utilContracts = new DisposableUtil();
                    utilContracts.util(mTvShow);
                    break;
                case "Take":
                    new TakeUtil().util(mTvShow);
                    break;
                case "Timer":
                    new TimerUtil().util(mTvShow);
                    break;
                case "Interval":
                    new IntervalUtil().util(mTvShow);
                    break;
                case "Single":
                    new SingleUtil().util(mTvShow);
                    break;
                case "Completable":
                    new CompletableUtil().util(mTvShow);
                    break;
                case "Reduce":
                    new ReduceUtil().util(mTvShow);
                    break;
                case "Buffer":
                    new BufferUtil().util(mTvShow);
                    break;
                case "Filter":
                    new FilterUtil().util(mTvShow);
                    break;
                case "Skip":
                    new SkipUtil().util(mTvShow);
                    break;
                case "Scan":
                    new ScanUtil().util(mTvShow);
                    break;
                case "Subject":
                    new SubjectUtil().util(mTvShow);
                    break;

            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (utilContracts != null) {
            utilContracts.onDestory();
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    public String getClassTag() {
        return getClass().getSimpleName();
    }
}
