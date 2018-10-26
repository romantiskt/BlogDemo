package com.wang.advance.tasks.design.responsibility;

/**
 * Created by wangyang on 2018/10/26.下午5:15
 */
public class AndroidDeveloper extends Developer {

    @Override
    protected void apply(int days) {
        this.vacationDay=days;
    }

    @Override
    public int getVacationDays() {
        return 0;
    }


}
