package com.wang.advance.tasks.widget.low.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.wang.advance.R;
import com.wang.advance.model.contracts.OnItemClickListener;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by wangyang on 2017/10/11.
 */

public class ListDialog extends Dialog{
    RecyclerView mRcyList;
    OnSelectedListener listener;
    List<String> datas;
    Context mContext;
    MultiTypeAdapter dividerAdapter;

    public ListDialog(Context context, List<String> datas) {
        super(context, R.style.dialogstyle);
        this.datas = datas;
        mContext = context;
    }

    OnItemClickListener onClickListener = new OnItemClickListener() {
        @Override
        public void click(int pos, View view) {
            if (listener != null) {
                listener.clickPos(pos);
                dismiss();
            }
        }

    };
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_buttom_popu_list);
        mRcyList = (RecyclerView) findViewById(R.id.rcy_list);
        mRcyList.setLayoutManager(new LinearLayoutManager(mContext));
        dividerAdapter = new MultiTypeAdapter();

        /* 注册类型和 View 的对应关系 */
        dividerAdapter.register(String.class, new ListDialogBinder(onClickListener));
        mRcyList.setAdapter(dividerAdapter);
        dividerAdapter.setItems(datas);
        dividerAdapter.notifyDataSetChanged();
        Window window = getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(
                getContext().getResources().getDrawable(android.R.color.transparent));
        WindowManager.LayoutParams params = window.getAttributes();// 先获得窗体的原始样式,我们在这个基础上改
        params.gravity = Gravity.CENTER ;// 设置弹出位置
        window.setAttributes(params);
    }

    public void setOnSelectedListener(OnSelectedListener listener) {
        this.listener = listener;
    }

    public interface OnSelectedListener {
        void clickPos(int pos);
    }

    public void setNewData(List<String> data) {
        this.datas = data;
        if (dividerAdapter == null) dividerAdapter.setItems(data);
    }

}
