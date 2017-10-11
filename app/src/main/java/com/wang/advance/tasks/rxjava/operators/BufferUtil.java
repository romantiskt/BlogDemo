package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by wangyang on 2017/10/11.
 */

public class BufferUtil extends UtilContracts {
    /**
     *  buffer(count,skip)  count为一次发射几个数据，skip为发射之后 跳过哪项
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Flowable.just(1,2,3,4,5,6,7)
                .buffer(2,1)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        tv.append("------------------------\n");
                         for(Integer integer:integers){
                             tv.append("accept.."+integer);
                             tv.append(LINE_SEPARATOR);
                         }
                    }
                });
    }
}
