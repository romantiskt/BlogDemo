package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/13.
 */

public class MergeUtil extends UtilContracts {
    /**
     * 将多个Observable合并为一个
     *
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Observable.merge(getObservable3(),getObservable1(), getObservable2())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        tv.append("accept.." + o.toString());
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }

    public List<String> initData(int start, int end) {
        List<String> D = new ArrayList<>();
        for (int i = start; i < end; i++) {
            D.add(i + ".....");
        }
        return D;
    }

    private Observable getObservable1() {
        return Observable.just(initData(0, 100));
    }

    private Observable getObservable3() {
        return Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(@NonNull ObservableEmitter e) throws Exception {
                Thread.sleep(2000);
                e.onNext("Hello world");
            }
        });
    }

    private Observable getObservable2() {
        return Observable.just(initData(-100, 0));
    }
}
