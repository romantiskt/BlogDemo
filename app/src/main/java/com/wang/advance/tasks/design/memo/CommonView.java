package com.wang.advance.tasks.design.memo;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by romantiskt on 2018/10/28.
 * 备忘录模式
 */

public class CommonView extends View {

    private boolean enable;

    private String text;

    public CommonView(Context context) {
        super(context);
    }


    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        CommonViewState ss = new CommonViewState(superState);
        ss.enable=enable;
        ss.text=text;
        return ss;
    }

    @Override protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof CommonViewState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        CommonViewState ss = (CommonViewState) state;
        enable = ss.enable;
        text = ss.text;
    }
}
