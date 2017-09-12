package com.wang.advance.model.widgetdiv;

import android.support.annotation.IntDef;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.wang.advance.R;
import com.wang.advance.model.touchview.AnnularView;
import com.wang.tools.base.BaseAct;
import com.wang.tools.common.UIUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by romantiskt on 2017/3/9.
 */

public class WidgetShowAct extends BaseAct {
    public static final String EXA_SHOW_TYPE = "exa_show_type";
    public static final int Annular = 1;

    @IntDef({Annular})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Types {
    }

    @Types
    int currentType = Annular;

    @Override
    protected void initData() {

    }

    RelativeLayout mRlParent;

    @Override
    protected void initView() {
        setContentView(R.layout.act_widget_show);
        mRlParent = (RelativeLayout) findViewById(R.id.rl_parent);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra(EXA_SHOW_TYPE, Annular);
            switch (intExtra) {
                case Annular:
                    AnnularView annularView = new AnnularView(this);
                    annularView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dp2px(200)));
                    annularView.setSourceData(new float[]{40,50,110},new String[]{"苹果","香蕉","梨子"});
                    mRlParent.addView(annularView);
                    break;
            }
        }
    }

    @Override
    public String getClassTag() {
        return null;
    }
}
