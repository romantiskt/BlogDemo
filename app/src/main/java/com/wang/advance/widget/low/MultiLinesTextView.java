package com.wang.advance.widget.low;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wang.advance.MainActivity;

import java.util.List;

/**
 * Created by wangyang on 2017/9/15.
 */

public class MultiLinesTextView extends TextView {
    private List<String> mDatas;

    public MultiLinesTextView(Context context) {
        this(context,null);
    }

    public MultiLinesTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setClickable(true);
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(Color.TRANSPARENT);
    }

    public void setmDatas(List<String> mDatas) {
        this.mDatas = mDatas;
        refreshViews();
    }

    private void refreshViews() {
       if(mDatas!=null){
           SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
           int start=0;
           int end=0;
           for(String s:mDatas){
               stringBuilder.append(s);
               end+=s.length();
               stringBuilder.setSpan(new ClickListener(s), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
               start=end;
           }
           setText(stringBuilder);
       }

    }

    public class ClickListener extends ClickableSpan {
        String url;
        public ClickListener(String s) {
            this.url=s;
        }

        @Override
        public void onClick(View widget) {
            Toast.makeText(widget.getContext(), url, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Color.RED);
        }
    }
}
