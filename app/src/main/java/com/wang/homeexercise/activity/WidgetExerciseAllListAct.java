package com.wang.homeexercise.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wang.homeexercise.R;
import com.wang.tools.base.BaseAct;

/**
 * Created by romantiskt on 2017/3/9.
 * 所有自定义view的list
 */

public class WidgetExerciseAllListAct extends BaseAct implements View.OnClickListener {
    @Override
    protected void initData() {

    }

    Button mBtnAnnular;

    @Override
    protected void initView() {
        setContentView(R.layout.act_widget_all);
        mBtnAnnular= (Button) findViewById(R.id.btn_annular);
        mBtnAnnular.setOnClickListener(this);
    }

    @Override
    public String getClassTag() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_annular:
                Intent intent = new Intent(this, WidgetShowAct.class);
                intent.putExtra(WidgetShowAct.EXA_SHOW_TYPE,WidgetShowAct.Annular);
                startActivity(intent);
                break;
        }
    }
}
