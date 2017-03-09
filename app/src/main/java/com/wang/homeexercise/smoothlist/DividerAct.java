package com.wang.homeexercise.smoothlist;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.wang.homeexercise.R;
import com.wang.homeexercise.adapter.DividerAdapter;
import com.wang.tools.base.BaseAct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyang on 2017/03/03/
 * data:2017/3/3 ..time:14:33
 * email: wyroman@163.com
 * projectName: instore
 * 描述: 作为对recyclerView的研究
 */
public class DividerAct extends BaseAct {
    List<String> mData;
    DividerAdapter mDividerAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void initData() {
        fillDataToList();
        mDividerAdapter.setNewData(mData);
    }

    private void fillDataToList() {
        mData=new ArrayList<>();
        for(int i=0;i<200;i++){
            mData.add(i+"");
        }
    }

    /**
     * 与view相关的变量写在此处
     */
    RecyclerView mRecyclerView;
    @Override
    protected void initView() {
        setContentView(R.layout.act_divider);
        mRecyclerView= (RecyclerView) findViewById(R.id.rcy);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mDividerAdapter=new DividerAdapter(this,mData));
        /*******************设置默认的分隔线*******************/
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }

    @Override
    public String getClassTag() {
        return this.getClass().getSimpleName();
    }
}
