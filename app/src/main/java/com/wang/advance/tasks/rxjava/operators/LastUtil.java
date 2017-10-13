package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by wangyang on 2017/10/13.
 */

public class LastUtil extends UtilContracts {
    /**
     * last(t)  只会发射最后一个数据，如果数据源为空则发射默认值t
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Flowable.just(1,2,3,4,5,6)
                .last(32)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        tv.append("accept.."+integer);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
