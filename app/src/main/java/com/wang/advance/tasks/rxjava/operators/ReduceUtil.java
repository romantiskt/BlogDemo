package com.wang.advance.tasks.rxjava.operators;

import android.widget.TextView;

import com.wang.advance.tasks.rxjava.UtilContracts;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wangyang on 2017/10/11.
 */

public class ReduceUtil extends UtilContracts {
    /**
     * reduce运算
     * 将输入的数前两项 根据提供的公式代入得到结果  再将此值和第三个数重复上述步骤，知道得到结果
     * @param tv
     *
     * reduce(x,...) 第一个参数表示得到的最后结果  再与这个值带入公式得到最后结果
     */
    @Override
    public void util(final TextView tv) {
        tv.setText(date);
        Flowable.just(1, 2, 3, 4, 5)
                .reduce(100,new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(@NonNull Integer integer, @NonNull Integer integer2) throws Exception {
                        return integer + integer2;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        tv.append("accept.." + integer);
                        tv.append(LINE_SEPARATOR);
                    }
                });
    }
}
