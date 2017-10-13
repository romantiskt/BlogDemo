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

public class ThrottleUtil extends UtilContracts {
    /**
     * 在每次事件触发后的一定时间间隔内丢弃新的事件  例如;throttleFirst throttleLast
     *
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                        Thread.sleep(0);
                        emitter.onNext(1); // skip
                        emitter.onNext(2); // deliver
                        Thread.sleep(505);
                        emitter.onNext(3); // skip
                        Thread.sleep(99);
                        emitter.onNext(4); // skip
                        Thread.sleep(100);
                        emitter.onNext(5); // skip
                        emitter.onNext(6); // deliver
                        Thread.sleep(305);
                        emitter.onNext(7); // deliver
                        Thread.sleep(510);
                        emitter.onComplete();
                    }
                })
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer s) throws Exception {
                        tv.append("accept.." + s);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
