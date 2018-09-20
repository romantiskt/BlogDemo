package com.wang.advance.tasks.hencoder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wang.advance.R;
import com.wang.advance.model.contracts.OnItemClickListener;
import com.wang.tools.base.BaseAct;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by romantiskt on 2018/9/20.
 */

public class HenCoderListAct extends BaseAct {

    @BindView(R.id.recy)
    RecyclerView mRecy;

    @Override
    protected int getLayoutId() {
        return R.layout.act_hencoder_list;
    }

    @Override
    protected void initDataAfterViewInflate() {

    }

    @Override
    protected void initView() {
        String arr[]=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        mRecy.setLayoutManager(new LinearLayoutManager(this));
        MultiTypeAdapter multiTypeAdapter=new MultiTypeAdapter();
        multiTypeAdapter.register(String.class,new ListHenCoderItem(onClickListener));
        mRecy.setAdapter(multiTypeAdapter);
        multiTypeAdapter.setItems(Arrays.asList(arr));
    }

    @Override
    public String getClassTag() {
        return this.getLocalClassName();
    }

    OnItemClickListener onClickListener = new OnItemClickListener() {
        @Override
        public void click(int pos, View view) {
            goAct(SingleHenCoderAct.class);
        }

    };
}
