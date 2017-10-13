package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/13.
 */

public class WindowUtil extends UtilContracts {
    /**
     * 和buffer的不同之处在于，window处理过后发射的是Observable
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Flowable.just(1,2,3,4,5,6,7,8,9)
                .window(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Flowable<Integer>>() {
                    @Override
                    public void accept(Flowable<Integer> integerFlowable) throws Exception {
                        tv.append("onNext..\n");
                        integerFlowable.subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                               tv.append("accept.."+integer);
                                tv.append(LINE_SEPARATOR);
                            }
                        });
                    }
                });
    }
}
