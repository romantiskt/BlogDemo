package com.wang.advance.tasks.design.pool;

import java.util.HashMap;

/**
 * Created by romantiskt on 2018/10/28.
 * 享元模式  即公用内存中的对象
 */

public class ThreadPool {

    private HashMap<String,Thread> pool=new HashMap<>();


    public void start(String task){
        if(pool.get(task)!=null){
            pool.get(task).run();
        }else {
            Thread thread=new WorkThread();
            pool.put(task,thread);
        }
    }
}
