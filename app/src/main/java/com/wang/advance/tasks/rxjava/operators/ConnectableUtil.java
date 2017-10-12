package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by wangyang on 2017/10/12.
 */

public class ConnectableUtil extends UtilContracts {
    /**
     * ConnectableObservable 和connect联合使用  connect会触发ConnectableObservable发射数据
     * 并且只会发射 connect()之后的数据；
     *
     * replay(count) 为缓存多少个事件 即使事件已经发射完  也还是可以通过订阅接收到事件
     * @param tv
     */
    @Override
    public void util(TextView tv) {
        tv.setText(date);
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(getFirstObserver(tv));
        ConnectableObservable<String> replay = subject.replay(2);
        replay.connect();
        subject.onNext("1");
        subject.onNext("2");
        subject.onNext("3");
        subject.onNext("4");
        replay.subscribe(getSecondObserver(tv));

    }

    private Consumer<String> getFirstObserver(final TextView tv) {
        return new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv.append("First_Observer_"+s);
                tv.append(LINE_SEPARATOR);
            }
        };
    }
    private Consumer<String> getSecondObserver(final TextView tv) {
        return new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv.append("Second_Observer_"+s);
                tv.append(LINE_SEPARATOR);
            }
        };
    }
}
