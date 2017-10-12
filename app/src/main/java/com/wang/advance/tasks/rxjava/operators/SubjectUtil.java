package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by wangyang on 2017/10/12.
 */

public class SubjectUtil extends UtilContracts {

    /**
     * PublishSubject  从哪里订阅，就从哪里开始发射数据
     * ReplaySubject   无论怎样，都会发射全部数据
     * AsyncSubject    只会发送最后一个,而且需要调用 onComplete()才会发射
     * BehaviorSubject  会从订阅的最近的上一个开始发射数据
     * @param tv
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.onNext("PublishSubject_Hello");
        publishSubject.onNext("PublishSubject_World");
        publishSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv.append("PublishSubject....accept.." + s);
                tv.append(LINE_SEPARATOR);
            }
        });
        publishSubject.onNext("China");


        ReplaySubject<String> replaySubject = ReplaySubject.create();
        replaySubject.onNext("Hello");
        replaySubject.onNext("World");
        replaySubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv.append("ReplaySubject....accept.." + s);
                tv.append(LINE_SEPARATOR);
            }
        });
        replaySubject.onNext("China");

        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.onNext("Hello");
        asyncSubject.onNext("World");
        asyncSubject.onNext("China");
        asyncSubject.onComplete();
        asyncSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv.append("AsyncSubject....accept.." + s);
                tv.append(LINE_SEPARATOR);
            }
        });

        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext("Hello");
        behaviorSubject.onNext("World");
        behaviorSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                tv.append("BehaviorSubject....accept.." + s);
                tv.append(LINE_SEPARATOR);
            }
        });
        behaviorSubject.onNext("China");
    }
}
