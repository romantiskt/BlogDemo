package com.wang.advance.tasks.rn.view;

import android.view.View;
import android.widget.ImageView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.wang.advance.R;
import com.wang.advance.tasks.widget.low.CircleView;

/**
 * Created by wangyang on 2018/5/30.下午3:52
 */
public class ReactCircleViewManager extends SimpleViewManager<View> {
    @Override
    public String getName() {
        return "ReactCircle";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        View inflate = View.inflate(reactContext, R.layout.rn_widger, null);
        return inflate;
    }
}
