package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class FilterUtil extends UtilContracts {
    /**
     * 根据条件过滤掉某些值
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Flowable.just(1, 2, 3, 4, 5)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(@NonNull Integer integer) throws Exception {
                        return integer > 2;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        tv.append("accept.." + integer);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
