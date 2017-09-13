package com.wang.advance.widget.enter;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.wang.advance.R;
import com.wang.advance.model.OnItemClickListener;
import com.wang.tools.base.BaseAct;

import java.util.Arrays;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by romantiskt on 2017/3/9.
 * 所有自定义view的list
 */

public class WidgetAllListAct extends BaseAct {
    @Override
    protected void initData() {

    }

        ViewType[] values = ViewType.values();
    RecyclerView mRlContainer;
    MultiTypeAdapter dividerAdapter;
    OnItemClickListener onClickListener = new OnItemClickListener() {
        @Override
        public void click(int pos, View view) {
            Intent intent=new Intent(WidgetAllListAct.this,ShowSingleWidgetAct.class);
            intent.putExtra(ShowSingleWidgetAct.EXA_SHOW_TYPE,values[pos].getTypeName());
            startActivity(intent);
        }

    };

    @Override
    protected void initView() {

        setContentView(R.layout.act_widget_all);
        mRlContainer = (RecyclerView) findViewById(R.id.rl_container);
        mRlContainer.setLayoutManager(new GridLayoutManager(this, 2));
        mRlContainer.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        dividerAdapter = new MultiTypeAdapter();

        /* 注册类型和 View 的对应关系 */
        dividerAdapter.register(ViewType.class, new ViewListBinder(onClickListener));
        mRlContainer.setAdapter(dividerAdapter);
        dividerAdapter.setItems(Arrays.asList(values));
        dividerAdapter.notifyDataSetChanged();
    }

    @Override
    public String getClassTag() {
        return this.getClass().getSimpleName();
    }


}
