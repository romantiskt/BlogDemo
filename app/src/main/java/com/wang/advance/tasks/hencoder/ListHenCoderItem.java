package com.wang.advance.tasks.hencoder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wang.advance.R;
import com.wang.advance.model.contracts.OnItemClickListener;
import com.wang.advance.tasks.widget.low.dialog.ListDialogBinder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by romantiskt on 2018/9/20.
 */

public class ListHenCoderItem extends ItemViewBinder<String, ListHenCoderItem.ViewHolder> {
    OnItemClickListener onClickListener;

    public ListHenCoderItem(OnItemClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_hencoder_divider, parent, false);
        return new ListHenCoderItem.ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull String item) {
        holder.itemTv.setText(item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final TextView itemTv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemTv = (TextView) itemView.findViewById(R.id.text);
            this.itemTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null)
                        onClickListener.click(getLayoutPosition(), v);
                }
            });
        }
    }
}
