package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by wangyang on 2017/10/13.
 */

public class DistinctUtil extends UtilContracts {
    /**
     * distinct 会过滤掉重复的数据源
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Flowable.just(1, 2, 3, 4, 1, 1, 2, 2, 3)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        tv.append("accept.." + integer);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
