package com.wang.homeexercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wang.homeexercise.activity.WidgetExerciseAllListAct;
import com.wang.homeexercise.smoothlist.DividerAct;
import com.wang.homeexercise.adapter.DividerAdapter;
import com.wang.tools.base.BaseAct;

import java.util.List;

public class MainActivity extends BaseAct {
    List<String> mData;
    DividerAdapter mDividerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    private Button btnDivider;
    private Button btnWidget;

    @Override
    protected void initView() {
        setContentView(R.layout.act_main);

        btnDivider = (Button) findViewById(R.id.btn_divider);
        btnWidget = (Button) findViewById(R.id.btn_widget);
        btnDivider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, DividerAct.class));
            }
        });
        btnWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, WidgetExerciseAllListAct.class));
            }
        });
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
