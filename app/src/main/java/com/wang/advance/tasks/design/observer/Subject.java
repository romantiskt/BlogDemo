package com.wang.advance.tasks.design.observer;

import java.util.Vector;

/**
 * Created by romantiskt on 2018/10/28.
 */

public abstract class Subject {

    public Vector<Observer> observerVector=new Vector<>();

    public void addObserver(Observer observer){
        observerVector.add(observer);
    }

    public void deleteObserver(Observer observer){
        observerVector.remove(observer);
    }

    public void notifyState(){
        for(Observer observer:observerVector){
            observer.stateChange();
        }
    }
}
