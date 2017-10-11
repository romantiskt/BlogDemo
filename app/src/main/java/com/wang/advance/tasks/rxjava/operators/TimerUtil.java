package com.wang.advance.tasks.rxjava.operators;

import android.util.Log;
import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class TimerUtil extends UtilContracts {
    /**
     * 延时任务
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        tv.append(" onSubscribe ");
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onNext(Long value) {
                        tv.append(" onNext : value : " + value);
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onError(Throwable e) {
                        tv.append(" onError : " + e.getMessage());
                        tv.append(LINE_SEPARATOR);
                    }

                    @Override
                    public void onComplete() {
                        tv.append(" onComplete");
                        tv.append(LINE_SEPARATOR);

                    }
                });
    }
}
