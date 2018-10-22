package com.wang.advance.tasks.design.singleton;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by romantiskt on 2018/10/22.
 * 单例模式的拓展：限制产生对象，单例性能的优化集，如线程池就可以看作单例模式的拓展
 */

public class SingletonAdvance {

    private static int maxInstance=2;//最大限制

    private static ArrayList<Object> parmsList=new ArrayList<>();//每个对象的属性

    private static ArrayList<SingletonAdvance> singletonAdvances=new ArrayList<>();

    private static int currentIndex;//当前对象的角标

    static {
        for (int i=0;i<maxInstance;i++){
            singletonAdvances.add(new SingletonAdvance("params"+i));
        }
    }

    private SingletonAdvance(){}

    private SingletonAdvance(Object params){
        parmsList.add(params);
    }

    /**
     * 随机取一个对象去操作
     * @return
     */
    public static SingletonAdvance getInstance(){
        Random random=new Random();
        currentIndex=random.nextInt(maxInstance);
        return singletonAdvances.get(currentIndex);
    }
}
