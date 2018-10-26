package com.wang.advance.tasks.design.iterator;

/**
 * Created by romantiskt on 2018/10/26.
 */

public interface IProject {

    public void add(String name,int num);

    public String getProjectInfo();

    public IProjectIterator iterator();
}
