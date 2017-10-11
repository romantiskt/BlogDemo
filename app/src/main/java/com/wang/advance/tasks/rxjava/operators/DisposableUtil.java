package com.wang.advance.tasks.rxjava.operators;

import android.os.SystemClock;
import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import java.util.Date;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class DisposableUtil extends UtilContracts {
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     * 用Disposable对observable统一进行管理，在ondestory前统一回收，防止内存泄漏
     *
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        compositeDisposable.add(getDisposable(tv));
        compositeDisposable.add(getDisposable(tv));
    }

    @android.support.annotation.NonNull
    private Disposable getDisposable(final TextView tv) {
        return getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        tv.append("accept" + s);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }

    /**
     * defer 操作符唯一和create的区别是
     * create创建Observable就进行了赋值操作，而defer是在订阅者订阅时才创建Observable，此时才进行真正的赋值操作
     *
     * @return
     */
    private Observable<String> getObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                SystemClock.sleep(2000);
                return Observable.just("1", "2", "3", "4");
            }
        });
    }

    @Override
    protected void onDestory() {
        compositeDisposable.clear();
        super.onDestory();
    }
}
