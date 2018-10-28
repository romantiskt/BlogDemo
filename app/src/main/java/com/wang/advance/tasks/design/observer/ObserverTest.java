package com.wang.advance.tasks.design.observer;

/**
 * Created by romantiskt on 2018/10/28.
 *
 * 观察者模式 类似于接口回调
 */

public class ObserverTest {

    public static void test(){
        WorkSubject subject=new WorkSubject();
        subject.addObserver(new Observer() {
            @Override
            public void stateChange() {
                 System.out.println("接收到了更新事件");
            }
        });
        subject.doSomething();
    }
}
