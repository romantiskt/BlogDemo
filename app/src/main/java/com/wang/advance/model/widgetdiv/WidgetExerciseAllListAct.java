package com.wang.advance.model.widgetdiv;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wang.advance.R;
import com.wang.advance.model.recyclerview.adapter.DividerAdapter;
import com.wang.advance.model.touchview.TouchAct;
import com.wang.tools.base.BaseAct;

import java.util.Arrays;

/**
 * Created by romantiskt on 2017/3/9.
 * 所有自定义view的list
 */

public class WidgetExerciseAllListAct extends BaseAct{
    @Override
    protected void initData() {

    }

   RecyclerView mRlContainer;
    String itemsName []=new String[]{"AnnularView","BrickView","CustomView1","CustomView2","CustomView3","CustomView4" ,
                                     "CustomView5","CustomView6","MatrixImageView","MultiCricleView","ShaderView"};
        DividerAdapter dividerAdapter;
    @Override
    protected void initView() {
        setContentView(R.layout.act_widget_all);
        mRlContainer= (RecyclerView) findViewById(R.id.rl_container);
        mRlContainer.setLayoutManager(new GridLayoutManager(this,2));
        mRlContainer.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mRlContainer.setAdapter(dividerAdapter=new DividerAdapter(this, Arrays.asList(itemsName)));
        mRlContainer.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                if(e.getAction()==MotionEvent.ACTION_UP){
                    Toast.makeText(rv.getContext(),"click",Toast.LENGTH_SHORT).show();
                }

                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }

    @Override
    public String getClassTag() {
        return this.getClass().getSimpleName();
    }


}
