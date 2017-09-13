package com.wang.advance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wang.advance.widget.enter.WidgetAllListAct;
import com.wang.tools.base.BaseAct;

import java.util.List;

public class MainActivity extends BaseAct {
    List<String> mData;

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
            }
        });
        btnWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, WidgetAllListAct.class));
            }
        });
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
