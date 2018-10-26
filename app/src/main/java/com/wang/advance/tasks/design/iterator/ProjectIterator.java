package com.wang.advance.tasks.design.iterator;

import java.util.ArrayList;

/**
 * Created by romantiskt on 2018/10/26.
 */

public class ProjectIterator implements IProjectIterator {

    private ArrayList<IProject> projectArrayList = new ArrayList<>();
    private int currentItem = 0;

    public ProjectIterator(ArrayList<IProject> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }

    @Override
    public boolean hasNext() {
        boolean hasNext = true;
        if (this.currentItem >= this.projectArrayList.size() || this.projectArrayList.get(this.currentItem) == null)
            hasNext = false;
        return hasNext;
    }

    @Override
    public IProject next() {
        return this.projectArrayList.get(this.currentItem++);
    }
}
