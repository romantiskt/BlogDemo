package com.wang.advance.tasks.design.observer;

/**
 * Created by romantiskt on 2018/10/28.
 */

public class WorkSubject extends Subject {

    public void doSomething(){
        System.out.println("具体做某些事情。。。");
        super.notifyState();
    }
}
