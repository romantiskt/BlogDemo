package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by wangyang on 2017/10/11.
 */

public class DisposUtil extends UtilContracts {
    /**
     * 当调用 disposable.dispose()时，会切断观察者和被观察者之间的联系
     * 即：被观察者会继续发送接下来的事件，但是观察者不再接收，有点相当于被观察者在调用onNext发送事件之后，调用onComplete()
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Observable.just(1,2,3,4,5)
                .subscribe(new Observer<Integer>() {
                    Disposable disposable;
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        disposable=d;
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        tv.append("onNext..."+integer);
                        tv.append(LINE_SEPARATOR);
                        if(integer==3){
                             disposable.dispose();
                         }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
