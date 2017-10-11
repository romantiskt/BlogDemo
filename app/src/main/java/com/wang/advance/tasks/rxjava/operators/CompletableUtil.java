package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class CompletableUtil extends UtilContracts {
    /**
     * Completable 与Observable的不同之处在于
     * Completable把onNext()事件忽略掉了 ，只关注事件的结果，而不发送事件
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
         Completable.timer(2, TimeUnit.SECONDS)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new CompletableObserver() {
                     @Override
                     public void onSubscribe(@NonNull Disposable d) {
                         tv.append(" onSubscribe ");
                         tv.append(LINE_SEPARATOR);
                     }

                     @Override
                     public void onComplete() {
                         tv.append(" onComplete ");
                         tv.append(LINE_SEPARATOR);
                     }

                     @Override
                     public void onError(@NonNull Throwable e) {
                         tv.append(" onError ");
                         tv.append(LINE_SEPARATOR);
                     }
                 });
    }
}
