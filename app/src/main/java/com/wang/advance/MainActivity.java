package com.wang.advance;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wang.advance.widget.enter.WidgetAllListAct;
import com.wang.advance.widget.low.MultiLinesTextView;
import com.wang.tools.base.BaseAct;

import java.util.ArrayList;
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
    private MultiLinesTextView mTv;

    @Override
    protected void initView() {
        setContentView(R.layout.act_main);

        btnDivider = (Button) findViewById(R.id.btn_divider);
        btnWidget = (Button) findViewById(R.id.btn_widget);
        mTv = (MultiLinesTextView) findViewById(R.id.text2);
        List<String> D = new ArrayList<>();
        D.add("Hello we are fjd fdfd fdj fjdjfj  ");
        D.add("World fdf ferfef erdfd ssfdfd  43434 43433333333333333333333333");
        mTv.setmDatas(D);
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

    public class click1 extends ClickableSpan {
        @Override
        public void onClick(View widget) {
            Toast.makeText(widget.getContext(), "click1", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Color.RED);
        }
    }

    public class click2 extends ClickableSpan {
        @Override
        public void onClick(View widget) {
            Toast.makeText(widget.getContext(), "click2", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Color.BLUE);
        }
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
