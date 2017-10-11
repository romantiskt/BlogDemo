package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Date;
import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class CommonUtil extends UtilContracts {
    /**
     * 最普通的用法
     * 在RxJava2中，数据源有两个类，一个Observable，一个是Flowable，
     * 区别在于Flowable能处理背压，
     * 而Obserable没有处理背压的能力。
     * 观察者也有两个，一个是Observer，适用于Observable。一个是Subscriber，适用于Flowable
     * <p>
     * <p>
     * <p>
     * 【背压概念】
     * 背压是指在异步场景中，被观察者发送事件速度远快于观察者的处理速度的情况下，一种告诉上游的被观察者降低发送速度的策略
     * 简而言之，背压是流速控制的一种策略。
     *
     *
     * 如下面 test1()中为一个是Flowable的例子，用法和Observable相当，只是Flowable支持背压，背压在及其频繁而业务比较重的
     * 场景中会有很好的表现，但是普通场景就不必要用了，
     *
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        io.reactivex.Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        tv.append("onSubscribe...");
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        tv.append("onNext..." + integer);
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        tv.append(LINE_SEPARATOR);
                        tv.append("onError..." + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        tv.append("onComplete...");
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }

    private void test1() {
        Flowable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
