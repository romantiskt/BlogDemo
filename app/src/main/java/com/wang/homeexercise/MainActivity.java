package com.wang.homeexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.wang.homeexercise.adapter.DividerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> mData;
    DividerAdapter mDividerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        fillDataToList();
        mDividerAdapter.setNewData(mData);
    }

    private void fillDataToList() {
        mData=new ArrayList<>();
        for(int i=0;i<200;i++){
            mData.add(i+"");
        }
    }

    RecyclerView mRecyclerView;

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.rcy);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mDividerAdapter=new DividerAdapter(this,mData));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }
}
