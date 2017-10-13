package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.concurrent.TimeUnit;

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

public class DebounceUtil extends UtilContracts {
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                        emitter.onNext(1); // skip
                        Thread.sleep(400);
                        emitter.onNext(2); // deliver
                        Thread.sleep(505);
                        emitter.onNext(3); // skip
                        Thread.sleep(100);
                        emitter.onNext(4); // deliver
                        Thread.sleep(605);
                        emitter.onNext(5); // deliver
                        Thread.sleep(510);
                        emitter.onComplete();
                    }
                })
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        tv.append("accept.."+integer);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
