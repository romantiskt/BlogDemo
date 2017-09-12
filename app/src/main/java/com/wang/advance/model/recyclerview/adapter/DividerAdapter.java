package com.wang.advance.model.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.wang.advance.R;

import java.util.List;

/**
 * Created by wangyang on 2017/03/03/
 * data:2017/3/3 ..time:10:52
 * email: wyroman@163.com
 * projectName: instore
 * 描述:
 */
public class DividerAdapter extends RecyclerView.Adapter<DividerAdapter.DividerViewHolder> {
    Context mContext;
    List<String> mDatas;

    public DividerAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        if(mContext==null)
            throw  new RuntimeException("this context is not null");
        this.mDatas = data;
    }

    @Override
    public DividerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DividerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_divider, null));
    }

    @Override
    public void onBindViewHolder(DividerViewHolder holder, int position) {
        holder.mTextView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        if (mDatas == null)
            return 0;
        return mDatas.size();
    }

    public void setNewData(List<String> newData) {
        mDatas = newData;
        notifyDataSetChanged();
    }

    public class DividerViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public DividerViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }

    }
}
