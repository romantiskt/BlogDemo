package com.wang.advance.tasks.nativ;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wang.advance.R;
import com.wang.tools.nativedemo.TaskNativeUtil;

/**
 * Created by wangyang on 2018/6/4.上午10:16
 */
public class NativeTestAct extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_native_test);
        ((TextView)findViewById(R.id.tv_title)).setText(TaskNativeUtil.stringFromJNI());
    }
}
