package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by wangyang on 2017/10/13.
 */

public class ConcatUtil extends UtilContracts {

    @Override
    public void util(final TextView tv) {
        testConcatMap(tv);
    }

    /**
     * concat 用于组合多个Observable 是有序的
     *
     * @param tv
     */
    private void testConcat(final TextView tv) {
        tv.setText(date);
        Observable.concat(Observable.just(1, 2, 3, 4), Observable.just(2, 3, 4, 5))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        tv.append("accept.." + integer);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }

    /**
     * 有序的将一个序列转化为另一个类型的序列
     *
     * @param tv
     */
    private void testConcatMap(final TextView tv) {
        tv.setText(date);
        Flowable.just(1, 2, 3, 4, 5)
                .concatMap(new Function<Integer, Publisher<String>>() {
                    @Override
                    public Publisher<String> apply(@NonNull final Integer integer) throws Exception {
                        String s=integer+"---->>>>>>>>";
                        return Flowable.just(s);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        tv.append("accept.." + s);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
