package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class SingleUtil extends UtilContracts {
    /**
     * Single与Observable的不同之处在于 Single只发射单一事件
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Single.just("Hello")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        tv.append("onSubscribe...");
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onSuccess(@NonNull String s) {
                        tv.append("onSuccess..." + s);
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        tv.append("onError...");
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
