package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class MapUtil extends UtilContracts {

    /**
     * map 操作符能对事件类型进行转换
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                        e.onNext("hello world");
                        e.onNext("wang");
                        e.onComplete();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(@NonNull String s) throws Exception {
                        return s.length();
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        tv.append("onSubscribe...");
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        tv.append("onNext..."+integer);
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        tv.append(LINE_SEPARATOR);
                        tv.append("onError..."+e.toString());
                    }

                    @Override
                    public void onComplete() {
                        tv.append("onComplete...");
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
