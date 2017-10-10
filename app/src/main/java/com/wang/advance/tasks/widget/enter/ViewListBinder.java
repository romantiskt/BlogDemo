package com.wang.advance.tasks.widget.enter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wang.advance.R;
import com.wang.advance.model.contracts.OnItemClickListener;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by wangyang on 2017/9/13.
 */

public class ViewListBinder extends ItemViewBinder<ViewType, ViewListBinder.ViewHolder> {
    OnItemClickListener onClickListener;
    public ViewListBinder(OnItemClickListener onClickListener) {
        this.onClickListener=onClickListener;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_divider, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ViewType item) {
       holder.itemTv.setText(item.getTypeName());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull private final TextView itemTv;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemTv= (TextView) itemView.findViewById(R.id.text);
            this.itemTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     if(onClickListener!=null)
                         onClickListener.click(getLayoutPosition(),v);
                }
            });
        }
    }
}
