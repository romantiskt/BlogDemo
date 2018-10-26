package com.wang.advance.tasks.design.iterator;

/**
 * Created by romantiskt on 2018/10/27.
 * 迭代器模式
 */

public class IteratorUtil {

    public static void test(){
        IProject project=new Project();
        for(int i=0;i<100;i++){
            project.add("name"+i,i);
        }

        IProjectIterator iterator = project.iterator();
        while (iterator.hasNext()){
            IProject next = (IProject) iterator.next();
            System.out.println(next.getProjectInfo());
        }
    }
}
