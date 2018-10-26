package com.wang.advance.tasks.design.responsibility;

/**
 * Created by wangyang on 2018/10/26.下午5:13
 */
public abstract class Developer {
    protected int vacationDay;

    /**
     * 申请请假天数
     *
     * @param days
     */
    protected abstract void apply(int days);


    /**
     * 获取请假天数
     *
     * @return
     */
    protected int getVacationDays() {
        return vacationDay;
    }

    ;
}
