package com.wang.advance.tasks.design.iterator;

import java.util.ArrayList;

/**
 * Created by romantiskt on 2018/10/26.
 */

public class Project implements IProject {

    private String name;
    private int num;
    private ArrayList<IProject> projectArrayList = new ArrayList<>();

    public Project() {

    }

    private Project(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public void add(String name, int num) {
        this.projectArrayList.add(new Project(name, num));
    }

    @Override
    public String getProjectInfo() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("name:" + this.name);
        buffer.append("num:" + this.num);
        return buffer.toString();
    }

    @Override
    public IProjectIterator iterator() {
        return new ProjectIterator(this.projectArrayList);
    }
}
