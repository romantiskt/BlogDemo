package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class TakeUtil extends UtilContracts {
    /**
     *take(count)  只发射前count项数量的事件
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Observable.just(1,2,3,4,5,6)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(4)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        tv.append("accept"+integer);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
